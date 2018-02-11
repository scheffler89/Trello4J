package de.balticsoftware.dao;

import de.balticsoftware.cons.TrelloMock;
import de.balticsoftware.entities.Board;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrelloTest {

    @Test
    public void shouldReturnFullAPICallUrl() {
        Trello trello = new Trello("mykey", "mytoken");
        assertEquals("https://api.trello.com/1/members/me/boards?key=mykey&token=mytoken", trello.buildApiCall("1/members/me/boards"));

    }

    @Test
    public void shouldReturnAllBoards() throws Exception {
        Trello trello = new Trello("mykey", "mytoken");
        List<Board> boards = trello.myBoards(TrelloMock.AC_BOARDS);

        assertTrue(boards.stream().filter(b -> b.getName().equals("Willkommens-Board")).findFirst().isPresent());
        assertTrue(boards.stream().filter(b -> b.getName().equals("API Test Board")).findFirst().isPresent());


        /*assertEquals("API Test Board", board.getName());
        assertEquals(null, board.getDesc());
        assertEquals("5a80306437896192ef3e150e", board.getId());
        assertEquals(null, board.getIdOrganization());
        assertEquals("https://trello.com/b/q6VTqs9o/api-test-board", board.getUrl());
        assertEquals("https://trello.com/b/q6VTqs9o", board.getShortUrl());*/

    }

}