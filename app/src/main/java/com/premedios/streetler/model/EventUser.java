package com.premedios.streetler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by premedios on 13/02/16.
 */

@Table(name = "EventUser")
public class EventUser extends Model {

    @Column(name = "eventId")
    public Event eventId;

    @Column(name = "userId")
    public User userId;
}
