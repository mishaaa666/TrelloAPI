import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TrelloTest {
 private String boardId;
 private String listId;
 private String cardId;

    @Test(priority = 1)
    public void checkCreateBoard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Board board = new Board();
        String name = "New board";


        Board createdBoard = retrofitBuilder.getTrelloApi().createBoard(board, name).execute().body();
        boardId = createdBoard.getId();
        Assert.assertEquals(createdBoard.getName(), name);

    }

    @Test(priority = 2)
    public void checkUpdateTest() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        String updatedName = "Updated board name";
        board.setName(updatedName);

        Board updatedBoard = retrofitBuilder.getTrelloApi().updateBoard(board, boardId).execute().body();
        Assert.assertEquals(updatedBoard.getName(), updatedName);
        System.out.println(boardId);
    }

//    @Test(priority = 6)
//    public void checkDeleteTest() throws IOException {
//        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
//        Board board = new Board();
//
//       int code = retrofitBuilder.getTrelloApi().deleteBoard(boardId, board.getKey(), board.getToken()).execute().code();
//        Assert.assertEquals(code, 200);
//    }

    @Test(priority = 3)
    public void checkCreateList() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        String listName = "New list";

        Board createdList = retrofitBuilder.getTrelloApi().createList(board, boardId, listName).execute().body();
        listId = createdList.getId();
        Assert.assertEquals(createdList.getName(), listName);
        System.out.println(listId);
    }

    @Test(priority = 4)
    public void checkCreateCard() throws IOException{
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        String cardName = "New card";

        Board createdCard = retrofitBuilder.getTrelloApi().createCard(board, listId, cardName).execute().body();
        cardId = createdCard.getId();
        Assert.assertEquals(createdCard.getName(), cardName);
    }

    @Test(priority = 5)
    public void checkUpdateCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        String updatedCardName = "Updated card name";
        board.setName(updatedCardName);

        Board updatedCard = retrofitBuilder.getTrelloApi().updateCard(board, cardId).execute().body();
        Assert.assertEquals(updatedCard.getName(), updatedCardName);
    }


    @Test(priority = 7)
    public void checkDeleteCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();

       int code = retrofitBuilder.getTrelloApi().deleteCard(cardId, board.getKey(), board.getToken()).execute().code();
        Assert.assertEquals(code, 200);
    }

    @Test(priority = 6)
    public void checkGetCard() throws IOException{
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();

//        String gettedCardName = "Here is your card";
//        board.setName(gettedCardName);

        int gettedCard = retrofitBuilder.getTrelloApi().getCard(cardId, board.getKey(), board.getToken()).execute().code();
        Assert.assertEquals(gettedCard, 200);
    }
}
