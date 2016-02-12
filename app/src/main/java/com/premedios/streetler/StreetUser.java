package com.premedios.streetler;

import java.sql.Date;

/**
 * Created by user on 12/02/2016.
 */
public class StreetUser {
    private int id;
    private String firstname;
    private String lastname;
    private String city;
    private Date dateofbirth;
    private long likesattributed;
    private StreetEvent[] events;
    private StreetNotification[] notifications;
    private StreetLike[] likes;
    private StreetImage[] images;
    private StreetVideo[] videos;

    public StreetUser() {

    }

    public StreetUser(int id, String firstname, String lastname, String city, Date dateofbirth, long likesattributed, StreetEvent[] events, StreetLike[] likes, StreetImage[] images, StreetVideo[] videos) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.dateofbirth = dateofbirth;
        this.likesattributed = likesattributed;
        this.events = events;
        this.likes = likes;
        this.images = images;
        this.videos = videos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public long getLikesattributed() {
        return likesattributed;
    }

    public void setLikesattributed(long likesattributed) {
        this.likesattributed = likesattributed;
    }

    public StreetEvent[] getEvents() {
        return events;
    }

    public void setEvents(StreetEvent[] events) {
        this.events = events;
    }

    public StreetLike[] getLikes() {
        return likes;
    }

    public void setLikes(StreetLike[] likes) {
        this.likes = likes;
    }

    public StreetImage[] getImages() {
        return images;
    }

    public void setImages(StreetImage[] images) {
        this.images = images;
    }

    public StreetVideo[] getVideos() {
        return videos;
    }

    public void setVideos(StreetVideo[] videos) {
        this.videos = videos;
    }
}
