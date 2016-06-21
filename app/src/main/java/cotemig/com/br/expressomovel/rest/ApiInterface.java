package cotemig.com.br.expressomovel.rest;

import java.util.ArrayList;

import cotemig.com.br.expressomovel.Entidades.Item;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;


public interface ApiInterface {
    @Headers("Content-Type: application/json")
    @GET("item/getItens")
    Call<ArrayList<Item>> getItens();

//    @Headers("Content-Type: application/json")
//    @GET("usuario/getUsuarios")
//    Call<ArrayList<Usuario>> getUsuarios();
//
//    @POST("usuario/usuario")
//    Call<ArrayList<Usuario>> setUsuario();
//
//    Atualiza usuario
//    PUT
//    /express-movel-web/api/usuario/usuario
//
//    Deleta Usuario
//    DELETE
//    /express-movel-web/api/usuario/usuario/{idUsuario}
//
//    ==============================================================
//    Itens
//
//    Recupera todos os itens
//    GET
//    /express-movel-web/api/item/getItens
//
//    Insere item
//    POST
//    /express-movel-web/api/item/item
//
//    Atualiza item
//    PUT
//    /express-movel-web/api/item/item
//
//    Deleta item
//    DELETE
//    /express-movel-web/api/item/item/{idItem}
//
//    Recupera itens para o cliente
//            GET
//    /express-movel-web/api/item/itensByIdCliente/{id}
//
//    Recupera itens para o entregador
//            GET
//    /express-movel-web/api/item/itensByIdEntregador/{id}
//
//    Aceita entrega item
//            PUT
//    /express-movel-web/api/item/aceitar/{idItem}/{idEntregador}
//
//    Realiza entrega item
//            PUT
//    /express-movel-web/api/item/entregar/{idItem}
//
//    Finaliza entrega item
//            PUT
//    /express-movel-web/api/item/finalizar/{idItem}

}
