import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloApi {

    @POST("/1/boards/")
    Call<Board> createBoard(@Body Board board, @Query("name") String name);

    @PUT("/1/boards/{id}")
    Call<Board> updateBoard(@Body Board board, @Path("id") String id);

    @DELETE("/1/boards/{id}")
    Call<Board> deleteBoard(@Path("id") String id, @Query("key") String key, @Query("token") String token);

    @POST("/1/boards/{id}/lists")
    Call<Board> createList(@Body Board board, @Path("id") String id, @Query("name") String listName);

    @POST("/1/cards")
    Call<Board> createCard(@Body Board board, @Query("idList") String listId, @Query("name") String cardName);

    @PUT("/1/cards/{id}")
    Call<Board> updateCard(@Body Board board, @Path("id") String cardId);

    @DELETE("/1/cards/{id}")
    Call<Board> deleteCard(@Path("id") String cardId, @Query("key") String key, @Query("token") String token);

    @GET("/1/cards/{id}")
    Call<Board> getCard(@Path("id") String cardId, @Query("key") String key, @Query("token") String token);

}
