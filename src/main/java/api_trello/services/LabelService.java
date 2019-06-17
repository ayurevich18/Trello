package api_trello.services;

import api_trello.models.Label;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface LabelService {


    @GET("labels/{id}")
    Call<Label>getLabels(@Path("id")String id);

    @POST("labels")
    Call<Label>createLabel(@Query("name")String name,@Query("color")String color,@Query("idBoard")String idBoard);

    @PUT("labels/{id}")
    Call<Label>updateLabel(@Path("id")String id,@Query("name")String name);

    @DELETE("labels/{id}")
    Call<Label>deleteLabel(@Path("id")String id);

}
