package com.premedios.streetler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by user on 12/02/2016.
 */

@Table(name = "EventVideo")
public class EventVideo extends Model {
    @Column(name = "videoURL")
    public String videoURL;

    @Column(name = "eventId")
    public Event eventId;

    @Column(name = "userId")
    public User userId;
}
