package api_trello.services;

import api_trello.models.Board;
import api_trello.models.TrelloList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface BoardsService {

    @GET("boards/{id}")
    Call<Board> getBoard(@Path("id")String id);


    @POST("boards")
    Call<Board> createBoard(@Query("name") String name);

    @DELETE("boards/{id}")
    Call<ResponseBody> deleteBoard(@Path("id")String id);

    @PUT("boards/{id}")
    Call<Board> updateBoard(@Path("id")String id, @Query("name")String name);

}
