package cotemig.com.br.expressomovel.Entidades;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Samuel Anderson on 24/05/2016.
 */

public class Item implements Serializable{
    @SerializedName("idItem")
    private Long idItem;
    @SerializedName("descricao")
    private String descricao;
    @SerializedName("dataRetirada")
    private String dataRetirada;
    @SerializedName("dataEntrega")
    private String dataEntrega;
    @SerializedName("localRetirada")
    private String localRetirada;
    @SerializedName("localEntrega")
    private String localEntrega;
    @SerializedName("idEntregador")
    private Long idEntregador;
    @SerializedName("idCliente")
    private Long idCliente;
    @SerializedName("preco")
    private Double preco;
    @SerializedName("status")
    private String status;


    public Item() {
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long iditem) {
        this.idItem = iditem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getLocalRetirada() {
        return localRetirada;
    }

    public void setLocalRetirada(String localRetirada) {
        this.localRetirada = localRetirada;
    }

    public String getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(String localEntrega) {
        this.localEntrega = localEntrega;
    }

    public Long getIdEntregador() {
        return idEntregador;
    }

    public void setIdEntregador(Long idEntregador) {
        this.idEntregador = idEntregador;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return idItem + " - " + descricao;
    }
}
