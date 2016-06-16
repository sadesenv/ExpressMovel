package cotemig.com.br.expressomovel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cotemig.com.br.expressomovel.Entidades.Usuario;
import cotemig.com.br.expressomovel.dao.UsuarioDAO;

public class CadastrarUsuarioActivity extends AppCompatActivity {
    private CadastroUsuarioHelper formHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        this.formHelper = new CadastroUsuarioHelper(this);

        if (getIntent().hasExtra("usuario")) {
            Usuario user = (Usuario) getIntent().getSerializableExtra("usuario");
            if (user != null) {
                formHelper.preencheFormulario(user);
            }
        }
    }


    public void Salvar(View view) {

        Usuario usuario = formHelper.getUsuarioFromForm();

        UsuarioDAO dao = new UsuarioDAO(this);

        if (usuario.getIdUsuario() != null) {
            dao.atualiza(usuario);
            Toast.makeText(CadastrarUsuarioActivity.this, "Usuário " + usuario.getTipoPerfil() + " atualizado", Toast.LENGTH_SHORT).show();
        } else {
            dao.insere(usuario);
            Toast.makeText(CadastrarUsuarioActivity.this, "Usuário " + usuario.getTipoPerfil() + " cadastrado", Toast.LENGTH_SHORT).show();
        }

        Intent i;

        if ("N".equals(usuario.getTipoPerfil())) {
            i = new Intent(CadastrarUsuarioActivity.this, ListarItensActivity.class);
            CadastrarUsuarioActivity.this.startActivity(i);
        } else {
            i = new Intent(CadastrarUsuarioActivity.this, ListarEntregasActivity.class);
            CadastrarUsuarioActivity.this.startActivity(i);
        }


        finish();



    }

    public void tipoPerfil(View view) {
        formHelper.ocultaComponentes();
    }
}
