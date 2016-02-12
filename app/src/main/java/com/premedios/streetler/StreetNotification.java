package com.premedios.streetler;

/**
 * Created by user on 12/02/2016.
 */
public class StreetNotification {
    private int id;
    private String type;
    private StreetUser user;

    public StreetNotification() {}

    public StreetNotification(int id, String type, StreetUser user) {
        this.id = id;
        this.type = type;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StreetUser getUser() {
        return user;
    }

    public void setUser(StreetUser user) {
        this.user = user;
    }
}
