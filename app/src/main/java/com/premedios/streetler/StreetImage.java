package com.premedios.streetler;

/**
 * Created by user on 12/02/2016.
 */
public class StreetImage {
    private int id;
    private byte[] image;
    private StreetEvent event;
    private StreetUser user;

    public StreetImage() {}

    public StreetImage(int id, byte[] image, StreetEvent event, StreetUser user) {
        this.id = id;
        this.image = image;
        this.event = event;
        this.user = user;
    }


}
