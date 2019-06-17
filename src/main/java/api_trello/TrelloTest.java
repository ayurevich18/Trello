package api_trello;

import api_trello.models.Board;
import api_trello.models.Card;
import api_trello.models.Label;
import api_trello.models.TrelloList;
import org.testng.annotations.Test;

import java.io.IOException;


public class TrelloTest {

    TrelloRestClient client = new TrelloRestClient();

    @Test
    public void boardTest() throws IOException {
        Board board = client.boardsService.createBoard("28").execute().body();
        System.out.println(board);
        Board board1 = client.boardsService.getBoard(board.id).execute().body();
        System.out.println(board1);
        Board board2 = client.boardsService.updateBoard(board.id, "test1").execute().body();
        System.out.println(board2);
        client.boardsService.deleteBoard(board.id).execute().body();
        System.out.println(client.boardsService.getBoard(board.id).execute().body());


    }

    @Test
    public void listTest() throws IOException {
        Board board = client.boardsService.createBoard("test12").execute().body();
        System.out.println(board);
        TrelloList trelloList = client.listsService.createList("test2",board.id).execute().body();
        System.out.println(trelloList);
        TrelloList trelloList1=client.listsService.getTrelloList(trelloList.id).execute().body();
        System.out.println(trelloList1);
        TrelloList trelloList2=client.listsService.updateList(trelloList.id,"teest").execute().body();
        System.out.println(trelloList2);

    }

    @Test
    public void cardTest() throws IOException {
        Board board = client.boardsService.createBoard("test39").execute().body();
        TrelloList trelloList = client.listsService.createList("yupi",board.id).execute().body();
        Card card=client.cardService.createCard(trelloList.id,"uuuuuuuu").execute().body();
        System.out.println(card);
        Card card1=client.cardService.getCard(card.id).execute().body();
        System.out.println(card1);
        Card card2=client.cardService.updateCard(card.id,"aaaa").execute().body();
        System.out.println(card2);
        Card card3=client.cardService.deleteCard(card.id).execute().body();
        System.out.println(client.cardService.getCard(card.id).execute().code());

    }

    @Test
    public void labelTest()throws IOException{
        Board board = client.boardsService.createBoard("test399").execute().body();
        Label label=client.labelService.createLabel("test","green",board.id).execute().body();
        System.out.println(label);
        Label label1=client.labelService.getLabels(label.id).execute().body();
        System.out.println(label1);
        Label label2=client.labelService.updateLabel(label.id,"111").execute().body();
        System.out.println(label2);
        Label label3=client.labelService.deleteLabel(label.id).execute().body();
        System.out.println(client.labelService.deleteLabel(label.id).execute().code());
    }
}