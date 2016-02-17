package com.premedios.streetler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by user on 12/02/2016.
 */
public class EventLike extends Model {
    @Column(name = "eventId")
    public Event eventId;

    @Column(name = "userId")
    public User userId;
}
