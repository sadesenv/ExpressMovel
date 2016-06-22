package cotemig.com.br.expressomovel.Entidades;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pedro on 08/06/16.
 */

public class Usuario implements Serializable{
    @SerializedName("idUsuario")
    public Integer idUsuario;
    @SerializedName("nome")
    private String nome;
    @SerializedName("endereco")
    private String endereco;
    @SerializedName("bairro")
    private String bairro;
    @SerializedName("cidade")
    private String cidade;
    @SerializedName("telefone")
    private String telefone;
    @SerializedName("email")
    private String email;
    @SerializedName("tipoPerfil")
    private String tipoPerfil;
    @SerializedName("tipoVeiculo")
    private String tipoVeiculo;
    @SerializedName("placa")
    private String placa;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public String getTipoVeiculo() { return tipoVeiculo; }

    public void setTipoVeiculo(String tipoVeiculo) { this.tipoVeiculo = tipoVeiculo; }

    public String getPlaca() { return placa; }

    public void setPlaca(String placa) { this.placa = placa; }
}
