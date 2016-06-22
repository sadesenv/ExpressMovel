package cotemig.com.br.expressomovel.Entidades;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Samuel Anderson on 24/05/2016.
 */

public class Item implements Serializable{
    @SerializedName("idItem")
    private Integer idItem;
    @SerializedName("descricao")
    private String descricao;
    @SerializedName("dataRetirada")
    private Date dataRetirada;
    @SerializedName("dataEntrega")
    private Date dataEntrega;
    @SerializedName("localRetirada")
    private String localRetirada;
    @SerializedName("localEntrega")
    private String localEntrega;
    @SerializedName("idEntregador")
    private Integer idEntregador;
    @SerializedName("idCliente")
    private Integer idCliente;
    @SerializedName("preco")
    private Double preco;
    @SerializedName("status")
    private String status;


    public Item() {
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer iditem) {
        this.idItem = iditem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataRetirada() {
        return dataRetirada.toString();
    }

    public void setDataRetirada(String dataRetirada) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataRetirada = formatter.parse(dataRetirada);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDataEntrega() {
        return dataEntrega.toString();
    }

    public void setDataEntrega(String dataEntrega) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataEntrega = formatter.parse(dataEntrega);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    public Integer getIdEntregador() {
        return idEntregador;
    }

    public void setIdEntregador(Integer idEntregador) {
        this.idEntregador = idEntregador;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
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
