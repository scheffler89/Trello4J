package de.balticsoftware.entities;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * A board is the basic object of Trello it may belong to 0 or 1 team contain 0 or more lists.
 *
 * @author Lennard Scheffler, lennard.scheffler@balticsoftware.de
 */
public class Board {

    private String id;
    private String name;
    private String descData;
    private boolean closed;
    private String idOrganization;
    private String url;
    private boolean pinned;
    private String shortUrl;
    //TODO: private Object prefs;
    //TODO: private Object labelNames;

    /**
     * @return The ID of the board.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The ID of the board.
     */
    @JsonSetter("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return The name of the board.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name The name of the board.
     */
    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return If the descData includes custom emoji, this will contain the data necessary to display them.
     */
    public String getDescData() {
        return descData;
    }

    /**
     *
     * @param descData If the descData of the board.
     */
    @JsonSetter("descData")
    public void setDescData(String descData) {
        this.descData = descData;
    }

    /**
     *
     * @return (1) true when the board has been closed or (2) false if not.
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     *
     * @param closed (1) true when the board has been closed or (2) false if not.
     */
    @JsonSetter("closed")
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    /**
     *
     * @return MongoID of the organization to which the board belongs.
     */
    public String getIdOrganization() {
        return idOrganization;
    }

    /**
     *
     * @param idOrganization MongoID of the organization to which the board belongs.
     */
    @JsonSetter("idOrganization")
    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    /**
     *
     * @return Boolean whether the board has been pinned or not.
     */
    public boolean isPinned() {
        return pinned;
    }

    /**
     *
     * @param pinned Boolean whether the board has been pinned or not.
     */
    @JsonSetter("pinned")
    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    /**
     *
     * @return Persistent URL for the board.
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url Persistent URL for the board.
     */
    @JsonSetter("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return URL for the board using only it's shortMongoID
     */
    public String getShortUrl() {
        return shortUrl;
    }

    /**
     *
     * @param shortUrl URL for the board using only it's shortMongoID
     */
    @JsonSetter("shortUrl")
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }


}
