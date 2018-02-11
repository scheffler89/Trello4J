package de.balticsoftware.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import de.balticsoftware.entities.Board;
import de.balticsoftware.entities.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * The Trello class is the central object that is used in order to wrap the Trello REST API. This object can be used in
 * order to get Boards, Cards or other objects from Trello.
 *
 * @author Lennard Scheffler, lennard.scheffler@balticsoftware.de
 */
public class Trello {

    private static Logger logger = LogManager.getLogger(Trello.class);

    private String key;
    private String token;

    public Trello(String key, String token) {
        this.key = key;
        this.token = token;
    }

    /**
     *
     * @return Secret API key used for OAuth-1-Authorization.
     */
    public String getKey() {
        return key;
    }

    /**
     *
     * @param key Secret API key used for OAuth-1-Authorization.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     *
     * @return Secret Token that varifies the access granted to the API.
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token Token that varifies the access granted to the API.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Build the URL for an API Call.
     * @param urlAppendix URL appendix for the API call.
     * @return URL String for executing an API call.
     */
    public String buildApiCall(String urlAppendix) {
        return "https://api.trello.com/" + urlAppendix + "?key=" + key + "&token=" + token;
    }

    /**
     * Execute an API call an get the API response.
     * @param urlAppendix URL appendix for the API call.
     * @return API response as JSON text.
     */
    public String executeApiCall(final String urlAppendix) {

        String callUrl = buildApiCall(urlAppendix);

        Client client = Client.create();

        logger.info("API request: " + callUrl);
        WebResource webResource = client
                .resource(callUrl);

        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String responseString = response.getEntity(String.class);

        logger.info("API response: " + responseString);

        return responseString;

    }

    /**
     * Get my Trello boards.
     * @param jsonResponse Pass JSON response as inversion of control.
     * @return List of Trello boards.
     * @throws Exception
     */
    public List<Board> myBoards(String jsonResponse) throws Exception {
        String responseString;
        if (jsonResponse == null) {
            responseString = executeApiCall("1/members/me/boards");
        }
        else {
            responseString = jsonResponse;
        }

        logger.info("Mapping JSON response to list of board objects ...");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.readValue(responseString, new TypeReference<List<Board>>(){});
    }

    /**
     * Get my Trello boards.
     * @return List of Trello boards.
     * @throws Exception
     */
    public List<Board> myBoards() throws Exception {
        return myBoards(null);
    }


    /**
     * Get a Trello board by its ID.
     * @param id ID of the Trello board.
     * @param jsonResponse Pass JSON response as inversion of control.
     * @return Board object with the given trello ID.
     */
    public Board board(String id, String jsonResponse) throws Exception {
        String responseString;
        if (jsonResponse == null) {
            responseString = executeApiCall("1/boards/" + id);
        }
        else {
            responseString = jsonResponse;
        }

        logger.info("Mapping JSON response to board object ...");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.readValue(responseString, Board.class);
    }

    /**
     * Get a Trello board by its ID.
     * @param id ID of the Trello board.
     * @return Board object with the given trello ID.
     */
    public Board board(String id) throws Exception {
        return board(id, null);
    }

    /**
     * Get a list of all cards of a specific board.
     *
     * @param boardId The id of the board from which to get the cards.
     * @param jsonResponse Pass JSON response as inversion of control.
     * @return List of cards on a specific board.
     */
    public List<Card> cardsOnBoard(String boardId, String jsonResponse) throws Exception {
        String responseString;
        if (jsonResponse == null) {
            responseString = executeApiCall("1/boards/" + boardId + "/cards");
        }
        else {
            responseString = jsonResponse;
        }

        logger.info("Mapping JSON response to list of cards ...");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.readValue(responseString, new TypeReference<List<Card>>(){});
    }

    /**
     * Get a list of all cards of a specific board.
     *
     * @param boardId The id of the board from which to get the cards.
     * @return List of cards on a specific board.
     */
    public List<Card> cardsOnBoard(String boardId) throws Exception {
        return cardsOnBoard(boardId, null);
    }
}
