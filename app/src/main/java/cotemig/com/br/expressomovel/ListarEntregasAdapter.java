package cotemig.com.br.expressomovel;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cotemig.com.br.expressomovel.Entidades.Item;

public class ListarEntregasAdapter extends RecyclerView.Adapter<ListarEntregasAdapter.ViewHolder> {
    private static ArrayList<Item> listaItens;

    public ListarEntregasAdapter(ArrayList<Item> i) {
        listaItens = i;
    }

    @Override
    public ListarEntregasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista_entregas, parent, false);

        // create ViewHolder

        ViewHolder holder = new ViewHolder(rowView);
        return holder;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.Id.setText(String.valueOf(listaItens.get(position).getIdItem()));
        viewHolder.DtEntrega.setText(listaItens.get(position).getDataEntrega());
        viewHolder.DtRetirada.setText(listaItens.get(position).getDataRetirada());
        viewHolder.LocalEntrega.setText(listaItens.get(position).getLocalEntrega());
        viewHolder.LocalRetirada.setText(listaItens.get(position).getLocalRetirada());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listaItens.size();
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView Id;
        public TextView DtEntrega;
        public TextView LocalRetirada;
        public TextView DtRetirada;
        public TextView LocalEntrega;
        public ImageButton btnRoute;

        public ViewHolder(View rowView) {
            super(rowView);

            Id = (TextView) rowView.findViewById(R.id.entrega_Id);
            DtEntrega = (TextView) rowView.findViewById(R.id.entrega_DtEntrega);
            LocalRetirada = (TextView) rowView.findViewById(R.id.entrega_LocalRetirada);
            DtRetirada = (TextView) rowView.findViewById(R.id.entrega_DtRetirada);
            LocalEntrega = (TextView) rowView.findViewById(R.id.entrega_LocalEntrega);
            btnRoute = (ImageButton) rowView.findViewById(R.id.entrega_btnRoute);

            btnRoute.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Bundle b = new Bundle();
                    b.putString("Origem", LocalRetirada.getText().toString());
                    b.putString("Destino", LocalEntrega.getText().toString());
                    Intent i = new Intent(v.getContext(), MapaActivity.class);
                    i.putExtras(b);
                    v.getContext().startActivity(i);
                }
            });

            rowView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    showPopup(v, getAdapterPosition());
//                    Toast.makeText(v.getContext(), "OnLongClick Version :" + versionName,
//                            Toast.LENGTH_SHORT).show();
                    return true;

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
                    switch (item.getItemId()) {
                        case R.id.editar:
                            Intent vaiProFormulario = new Intent(v.getContext(), CadastrarItemActivity.class);

                            vaiProFormulario.putExtra("item", listaItens.get(position));

                            v.getContext().startActivity(vaiProFormulario);

                            Toast.makeText(v.getContext(), "Editar " + listaItens.get(position).getDescricao(), Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.deletar:
                            // do what you need .
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

}
