package cotemig.com.br.expressomovel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import cotemig.com.br.expressomovel.Entidades.Item;
import cotemig.com.br.expressomovel.dao.ItemDAO;
import cotemig.com.br.expressomovel.dao.UsuarioDAO;
import cotemig.com.br.expressomovel.rest.ApiClient;
import cotemig.com.br.expressomovel.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastrarItemActivity extends AppCompatActivity {

    private CadastroItemHelper formHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.formHelper = new CadastroItemHelper(this);

        Item item = (Item) getIntent().getSerializableExtra("item");
        if (item != null) {
            formHelper.preencheFormulario(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem itemMenu) {

        switch (itemMenu.getItemId()) {

            case R.id.menu_formulario:

                Item item = formHelper.getItemFromForm();

                ItemDAO dao = new ItemDAO(this);

                if (item.getIdItem() != null) {
                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                    Call<Integer> call = apiService.atualizaItem(item);
                    call.enqueue(new Callback<Integer>() {
                        @Override
                        public void onResponse(Call<Integer> call, Response<Integer> response) {
                            int statusCode = response.code();
                            Integer resposta = response.body();

                            Toast.makeText(CadastrarItemActivity.this, "Item " + resposta.toString() + " atualizado", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Integer> call, Throwable t) {
                            // Log error here since request failed
                            Toast.makeText(CadastrarItemActivity.this, "Error: " + t.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    UsuarioDAO userDao = new UsuarioDAO(this);

                    item.setIdCliente(userDao.getId());
                    item.setIdItem(0);

                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                    Call<Integer> call = apiService.insereItem(item);
                    call.enqueue(new Callback<Integer>() {
                        @Override
                        public void onResponse(Call<Integer> call, Response<Integer> response) {
                            int statusCode = response.code();
                            Integer resposta = response.body();

                            Toast.makeText(CadastrarItemActivity.this, "Item " + resposta.toString() + " cadastrado", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Integer> call, Throwable t) {
                            // Log error here since request failed
                            Toast.makeText(CadastrarItemActivity.this, "Error: " + t.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                finish();

                break;

        }

        return super.onOptionsItemSelected(itemMenu);
    }

}
