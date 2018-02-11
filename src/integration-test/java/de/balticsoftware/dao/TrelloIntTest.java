package de.balticsoftware.dao;

import de.balticsoftware.entities.Board;
import de.balticsoftware.entities.Card;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class TrelloIntTest {

    public static final String API_TEST_BOARD_ID = "5a80306437896192ef3e150e";
    // Trello test Boards for API testing
    public static String API_KEY = "5300c8bb9153a413d95aeaaa613b1a87";
    public static String API_TOKEN = "903b5aef29abdeaf3ffdde9638e433eab5fa6b0af187ef818bfc18e9380a3007";

    @Test
    public void shouldReturnServerResponse() {
        Trello trello = new Trello(API_KEY, API_TOKEN);
        String response = trello.executeApiCall("1/members/me/boards");
        assertNotNull(response);
        assertTrue(response.length() > 0);
    }

    @Test
    public void shouldReturnMyBoards() throws Exception {
        Trello trello = new Trello(API_KEY, API_TOKEN);
        List<Board> boards = trello.myBoards();
        Optional<Board> board = boards.stream().filter(b -> b.getName().equals("API Test Board")).findFirst();
        assertTrue(board.isPresent());
    }

    @Test
    public void shouldReturnApiTestBoard() throws Exception {
        Trello trello = new Trello(API_KEY, API_TOKEN);
        Board board = trello.board("5a80306437896192ef3e150e");
        assertEquals("API Test Board", board.getName());
    }

    @Test
    public void shoudReturnAllCardsOfApiTestBoard() throws Exception {
        Trello trello = new Trello(API_KEY, API_TOKEN);
        List<Card> cards = trello.cardsOnBoard(API_TEST_BOARD_ID);
        Optional<Card> card = cards.stream().filter(c -> c.getName().equals("Testcard")).findFirst();
        assertTrue(card.isPresent());
    }

}
