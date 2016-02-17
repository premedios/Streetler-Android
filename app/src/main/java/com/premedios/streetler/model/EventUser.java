package com.premedios.streetler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by premedios on 13/02/16.
 */
public class EventUser extends Model {

    @Column(name = "eventId")
    public Event eventId;

    @Column(name = "userId")
    public User userId;
}
