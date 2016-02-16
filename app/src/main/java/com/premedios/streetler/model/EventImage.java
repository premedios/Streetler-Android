package com.premedios.streetler.model;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by user on 12/02/2016.
 */

@Table(name = "Event Images")

public class EventImage {
    @Column(name = "image")
    public byte[] image;

    @Column(name = "user")
    private User user;

}
