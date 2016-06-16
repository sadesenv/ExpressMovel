package cotemig.com.br.expressomovel;

import android.widget.CheckBox;
import android.widget.EditText;

import cotemig.com.br.expressomovel.Entidades.Item;
import cotemig.com.br.expressomovel.Entidades.Usuario;

/**
 * Created by pedro on 08/06/16.
 *
 * Classe responsável pela manipulação dos componentes da tela de cadastro
 * @see CadastrarUsuarioActivity
 *
 */
public class CadastroItemHelper {

    private EditText txtDescricao;
    private EditText txtDataEntrega;
    private EditText txtDataRetirada;
    private EditText txtLocalEntrega;
    private EditText txtLocalRetirada;


    private Item item;

    public CadastroItemHelper(CadastrarItemActivity activity) {

        txtDescricao = (EditText) activity.findViewById(R.id.cadastrar_item_descricao);
        txtDataEntrega = (EditText) activity.findViewById(R.id.cadastrar_item_data_entrega);
        txtDataRetirada = (EditText) activity.findViewById(R.id.cadastrar_item_data_retirada);
        txtLocalEntrega = (EditText) activity.findViewById(R.id.cadastrar_item_local_entrega);
        txtLocalRetirada = (EditText) activity.findViewById(R.id.cadastrar_item_local_retirada);

        this.item = new Item();
    }


    public Item getItemFromForm(){
        item.setDescricao(txtDescricao.getText().toString());
        item.setDataEntrega(txtDataEntrega.getText().toString());
        item.setDataRetirada(txtDataRetirada.getText().toString());
        item.setLocalEntrega(txtLocalEntrega.getText().toString());
        item.setLocalRetirada(txtLocalRetirada.getText().toString());


        return item;
    }

    public void preencheFormulario(Item item) {
        txtDescricao.setText(item.getDescricao());
        txtDataEntrega.setText(item.getDataEntrega());
        txtDataRetirada.setText(item.getDataRetirada());
        txtLocalEntrega.setText(item.getLocalEntrega());
        txtLocalRetirada.setText(item.getLocalRetirada());

        this.item = item;
    }
}
