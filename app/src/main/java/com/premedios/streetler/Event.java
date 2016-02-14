package com.premedios.streetler;

/**
 * Created by user on 12/02/2016.
 */

public class Event {
    private int id;
    private String type;
    private String name;
    private String description;
    private String imageURL;

    public Event() {
    }

    public Event(String type, String name, String description, String imageURL) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
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

    public String getImageURL() {
        return imageURL;
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

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }
}
