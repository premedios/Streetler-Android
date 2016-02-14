package com.premedios.streetler;

/**
 * Created by user on 12/02/2016.
 */
public class EventImage {
    private int id;
    private byte[] image;
    private Event eventId;
    private User userId;

    public EventImage() {}

    public EventImage(int id, byte[] image, Event eventId, User userId) {
        this.id = id;
        this.image = image;
        this.eventId = eventId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
