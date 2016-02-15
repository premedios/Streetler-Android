package com.premedios.streetler.model;

/**
 * Created by user on 12/02/2016.
 */
public class EventVideo {
    private int id;
    private byte[] video;
    private Event eventId;
    private User userId;

    public EventVideo() {}

    public EventVideo(int id, byte[] video, Event event, User user) {
        this.id = id;
        this.video = video;
        this.eventId = event;
        this.userId = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
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
