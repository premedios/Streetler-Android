package com.premedios.streetler;

/**
 * Created by user on 12/02/2016.
 */
public class StreetLike {
    private int id;
    private StreetEvent event;
    private StreetUser user;

    public StreetLike(int id, StreetEvent event, StreetUser user) {
        this.id = id;
        this.event = event;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StreetEvent getEvent() {
        return event;
    }

    public void setEvent(StreetEvent event) {
        this.event = event;
    }

    public StreetUser getUser() {
        return user;
    }

    public void setUser(StreetUser user) {
        this.user = user;
    }
}
