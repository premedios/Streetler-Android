package com.premedios.streetler.model;

/**
 * Created by premedios on 13/02/16.
 */
public class EventUser {
    private int id;
    private Event eventId;
    private User userId;

    public EventUser() {}

    public EventUser(int id, Event eventId, User userId) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
