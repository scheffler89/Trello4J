package de.balticsoftware.dao;

import de.balticsoftware.entities.Board;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class TrelloIntTest {

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

}
