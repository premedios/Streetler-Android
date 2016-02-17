package com.premedios.streetler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by user on 12/02/2016.
 */

@Table(name = "Event Images")

public class EventImage extends Model {
    @Column(name = "imageURL")
    public String imageURL;

    @Column(name = "user")
    private User user;

    @Column(name = "event")
    public Event event;

}
