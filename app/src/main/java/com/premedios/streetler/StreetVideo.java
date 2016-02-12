package com.premedios.streetler;

/**
 * Created by user on 12/02/2016.
 */
public class StreetVideo {
    private int id;
    private byte[] video;
    private StreetEvent event;
    private StreetUser user;

    public StreetVideo() {}

    public StreetVideo(int id, byte[] video, StreetEvent event, StreetUser user) {
        this.id = id;
        this.video = video;
        this.event = event;
        this.user = user;
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
