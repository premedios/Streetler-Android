package com.premedios.streetler;

/**
 * Created by user on 12/02/2016.
 */

public class StreetEvent {
    private int id;
    private String type;
    private String name;
    private String description;
    private byte[] image;
    private StreetUser creator;

    public StreetEvent() {
    }

    public StreetEvent(String type, String name, String description, byte[] image, StreetUser creator) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.image = image;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return image;
    }

    public StreetUser getCreator() {
        return creator;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setCreator(StreetUser creator) {
        this.creator = creator;
    }
}
