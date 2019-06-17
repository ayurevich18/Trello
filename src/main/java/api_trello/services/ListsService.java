package api_trello.services;

import api_trello.models.TrelloList;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


public interface ListsService {
    @GET("lists/{id}")
    Call<TrelloList>getTrelloList(@Path("id")String id);

    @POST("lists")
    Call<TrelloList>createList(@Query("name")String name,@Query("idBoard") String idBoard);

    @PUT("lists/{id}")
    Call<TrelloList>updateList(@Path("id")String id,@Query("name")String name);








}
