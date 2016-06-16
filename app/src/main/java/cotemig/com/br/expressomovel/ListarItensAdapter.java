package cotemig.com.br.expressomovel;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import cotemig.com.br.expressomovel.Entidades.Item;
import cotemig.com.br.expressomovel.dao.ItemDAO;

public class ListarItensAdapter extends RecyclerView.Adapter<ListarItensAdapter.ViewHolder> {
    private static ArrayList<Item> listaItens;
    public static Context aContext;

    public ListarItensAdapter(Context context, ArrayList<Item> i) {
        aContext = context;
        listaItens = i;
    }

    @Override
    public ListarItensAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista_itens, parent, false);

        // create ViewHolder

        ViewHolder aHolder = new ViewHolder(rowView);
        return aHolder;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.Id.setText(String.valueOf(listaItens.get(position).getIdItem()));
        viewHolder.Descricao.setText(listaItens.get(position).getDescricao());
        viewHolder.DtEntrega.setText(listaItens.get(position).getDataEntrega());
        viewHolder.DtRetirada.setText(listaItens.get(position).getDataRetirada());
        viewHolder.LocalEntrega.setText(listaItens.get(position).getLocalEntrega());
        viewHolder.LocalRetirada.setText(listaItens.get(position).getLocalRetirada());
        viewHolder.Entregador.setText(String.valueOf(listaItens.get(position).getIdEntregador()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listaItens.size();
    }

    // inner class to hold a reference to each item of RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView Id;
        public TextView Descricao;
        public TextView DtEntrega;
        public TextView LocalRetirada;
        public TextView DtRetirada;
        public TextView LocalEntrega;
        public TextView Entregador;

        public ViewHolder(View rowView) {
            super(rowView);

            Id = (TextView) rowView.findViewById(R.id.pedido_Id);
            Descricao = (TextView) rowView.findViewById(R.id.pedido_Descricao);
            DtEntrega = (TextView) rowView.findViewById(R.id.pedido_DtEntrega);
            LocalRetirada = (TextView) rowView.findViewById(R.id.pedido_LocalRetirada);
            DtRetirada = (TextView) rowView.findViewById(R.id.pedido_DtRetirada);
            LocalEntrega = (TextView) rowView.findViewById(R.id.pedido_LocalEntrega);
            Entregador = (TextView) rowView.findViewById(R.id.pedido_Entregador);

            rowView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View view) {
                    showPopup(view, getAdapterPosition());
                    return false;
                }
            });
        }

        private void showPopup(final View v, final int position) {
            PopupMenu popup = new PopupMenu(v.getContext(), v);
            MenuInflater inflate = popup.getMenuInflater();
            inflate.inflate(R.menu.menu_listar_itens, popup.getMenu());

            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    String itemDescricao = listaItens.get(position).getDescricao();

                    switch (item.getItemId()) {
                        case R.id.editar:
                            Intent vaiProFormulario = new Intent(aContext, CadastrarItemActivity.class);
                            vaiProFormulario.putExtra("item", listaItens.get(position));
                            aContext.startActivity(vaiProFormulario);
                            Toast.makeText(aContext, "Editar " + itemDescricao, Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.deletar:
                            ItemDAO itemDAO = new ItemDAO(aContext);
                            if (listaItens.get(position).getIdEntregador() != null) {
                                itemDAO.deletar(listaItens.get(position));
                                removeAt(getAdapterPosition());
                                Toast.makeText(aContext, "Deletar " + itemDescricao, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(aContext, "Item " + itemDescricao + "não pode ser excluido!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        default:
                            return false;
                    }
                    return false;
                }
            });
            popup.show();
        }
    }

    public void removeAt(int position) {
        listaItens.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listaItens.size());
    }

}
