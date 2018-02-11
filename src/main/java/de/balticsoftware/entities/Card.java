package de.balticsoftware.entities;

import java.util.Calendar;

/**
 * Lists in Trello contain cards. A card belongs to exactly one list.
 *
 * @author Lennard Scheffler, lennard.scheffler@balticsoftware.de
 */
public class Card {

    private String id;
    //TODO: private Object badges;
    private boolean closed;
    private Calendar dateLastActivity;
    private String desc;
    //TODO: private Object descData;
    private Calendar due;
    private boolean dueComplete;
    private String email;
    private String idAttachedCover;
    private String idBoard;
    private String[] idChecklists;
    private String[] idLabels;
    private String itList;
    private String[] idMembers;
    private String[] idMembersVoted;
    private int idShort;
    //TODO: private Labels[] lables;
    private boolean manualCoverAttachment;
    private String name;
    private float pos;
    private String shortLink;
    private String shortUrl;
    private boolean subscribed;
    private String url;

    /**
     *
     * @return The ID of the card
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id The ID of the card
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return Whether the card is closed (archived). Note: Archived lists and boards do not cascade archives to cards. A card can have closed: false but be on an archived board.
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     *
     * @param closed Whether the card is closed (archived). Note: Archived lists and boards do not cascade archives to cards. A card can have closed: false but be on an archived board.
     */
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    /**
     *
     * @return The datetime of the last activity on the card. Note: There are activities that update dateLastActivity that do not create a corresponding action. For instance, updating the name field of a checklist item on a card does not create an action but does update the card and board's dateLastActivity value.
     */
    public Calendar getDateLastActivity() {
        return dateLastActivity;
    }

    /**
     *
     * @param dateLastActivity The datetime of the last activity on the card. Note: There are activities that update dateLastActivity that do not create a corresponding action. For instance, updating the name field of a checklist item on a card does not create an action but does update the card and board's dateLastActivity value.
     */
    public void setDateLastActivity(Calendar dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
    }

    /**
     *
     * @return The description for the card. Up to 16384 chars.
     */
    public String getDesc() {
        return desc;
    }

    /**
     *
     * @param desc The description for the card. Up to 16384 chars.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     *
     * @return The due date on the card, if one exists.
     */
    public Calendar getDue() {
        return due;
    }

    /**
     *
     * @param due The due date on the card, if one exists.
     */
    public void setDue(Calendar due) {
        this.due = due;
    }

    /**
     *
     * @return Whether the due date has been marked complete.
     */
    public boolean isDueComplete() {
        return dueComplete;
    }

    /**
     *
     * @param dueComplete Whether the due date has been marked complete.
     */
    public void setDueComplete(boolean dueComplete) {
        this.dueComplete = dueComplete;
    }

    /**
     *
     * @return Requires write access to be returned
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return The id of the attachment selected as the cover image, if one exists.
     */
    public String getIdAttachedCover() {
        return idAttachedCover;
    }

    /**
     *
     * @param idAttachedCover The id of the attachment selected as the cover image, if one exists.
     */
    public void setIdAttachedCover(String idAttachedCover) {
        this.idAttachedCover = idAttachedCover;
    }

    /**
     *
     * @return The ID of the board the card is on.
     */
    public String getIdBoard() {
        return idBoard;
    }

    /**
     *
     * @param idBoard The ID of the board the card is on.
     */
    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    /**
     *
     * @return An array of checklist IDs that are on this card.
     */
    public String[] getIdChecklists() {
        return idChecklists;
    }

    /**
     *
     * @param idChecklists An array of checklist IDs that are on this card.
     */
    public void setIdChecklists(String[] idChecklists) {
        this.idChecklists = idChecklists;
    }

    /**
     *
     * @return An array of label IDs that are on this card.
     */
    public String[] getIdLabels() {
        return idLabels;
    }

    /**
     *
     * @param idLabels An array of label IDs that are on this card
     */
    public void setIdLabels(String[] idLabels) {
        this.idLabels = idLabels;
    }

    /**
     *
     * @return The ID of the list the card is in.
     */
    public String getItList() {
        return itList;
    }

    /**
     *
     * @param itList The ID of the list the card is in.
     */
    public void setItList(String itList) {
        this.itList = itList;
    }

    /**
     *
     * @return An array of member IDs that are on this card.
     */
    public String[] getIdMembers() {
        return idMembers;
    }

    /**
     *
     * @param idMembers An array of member IDs that are on this card.
     */
    public void setIdMembers(String[] idMembers) {
        this.idMembers = idMembers;
    }

    /**
     *
     * @return An array of member IDs who have voted on this card
     */
    public String[] getIdMembersVoted() {
        return idMembersVoted;
    }

    /**
     *
     * @param idMembersVoted An array of member IDs who have voted on this card.
     */
    public void setIdMembersVoted(String[] idMembersVoted) {
        this.idMembersVoted = idMembersVoted;
    }

    /**
     *
     * @return Numeric ID for the card on this board. Only unique to the board, and subject to change as the card moves.
     */
    public int getIdShort() {
        return idShort;
    }

    /**
     *
     * @param idShort Numeric ID for the card on this board. Only unique to the board, and subject to change as the card moves.
     */
    public void setIdShort(int idShort) {
        this.idShort = idShort;
    }

    /**
     *
     * @return Whether the card cover image was selected automatically by Trello, or manually by the user.
     */
    public boolean isManualCoverAttachment() {
        return manualCoverAttachment;
    }

    /**
     *
     * @param manualCoverAttachment Whether the card cover image was selected automatically by Trello, or manually by the user.
     */
    public void setManualCoverAttachment(boolean manualCoverAttachment) {
        this.manualCoverAttachment = manualCoverAttachment;
    }

    /**
     *
     * @return Name of the card.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Name of the card.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Position of the card in the list.
     */
    public float getPos() {
        return pos;
    }

    /**
     *
     * @param pos Position of the card in the list.
     */
    public void setPos(float pos) {
        this.pos = pos;
    }

    /**
     *
     * @return The 8 character shortened ID for the card.
     */
    public String getShortLink() {
        return shortLink;
    }

    /**
     *
     * @param shortLink The 8 character shortened ID for the card.
     */
    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    /**
     *
     * @return URL to the card without the name slug.
     */
    public String getShortUrl() {
        return shortUrl;
    }

    /**
     *
     * @param shortUrl URL to the card without the name slug.
     */
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    /**
     *
     * @return Whether this member is subscribed to the card.
     */
    public boolean isSubscribed() {
        return subscribed;
    }

    /**
     *
     * @param subscribed Whether this member is subscribed to the card.
     */
    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    /**
     *
     * @return Full URL to the card, with the name slug.
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url Full URL to the card, with the name slug.
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
