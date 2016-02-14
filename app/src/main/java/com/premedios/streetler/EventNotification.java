package com.premedios.streetler;

/**
 * Created by user on 12/02/2016.
 */
public class EventNotification {
    private int id;
    private String eventType;
    private User userId;

    public EventNotification() {}

    public EventNotification(int id, String type, User userId) {
        this.id = id;
        this.eventType = type;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String type) {
        this.eventType = type;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId= userId;
    }
}
