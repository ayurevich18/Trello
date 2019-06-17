package api_trello;

import api_trello.interceptors.TrelloAuthInterceptor;
import api_trello.models.TrelloList;
import api_trello.services.BoardsService;
import api_trello.services.CardService;
import api_trello.services.LabelService;
import api_trello.services.ListsService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class TrelloRestClient {
    public static final String HOME_IO_BASE_URL = "https://api.trello.com/1/";


    public BoardsService boardsService;
    public ListsService listsService;
    public CardService cardService;
    public LabelService labelService;


    public TrelloRestClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new TrelloAuthInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(HOME_IO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        boardsService = retrofit.create(BoardsService.class);
        listsService = retrofit.create(ListsService.class);
        cardService=retrofit.create(CardService.class);
      labelService=retrofit.create(LabelService.class);

    }
}
