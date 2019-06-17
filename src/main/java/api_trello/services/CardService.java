package api_trello.services;

import api_trello.models.Card;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CardService {

    @GET("cards/{id}")
    Call<Card>getCard(@Path("id")String id);

    @POST("cards")
    Call<Card>createCard(@Query("idList")String idList,@Query("name")String name);

    @PUT("cards/{id}")
    Call<Card>updateCard(@Path("id")String id,@Query("name") String name);

    @DELETE("cards/{id}")
    Call<Card>deleteCard(@Path("id")String id);
}
