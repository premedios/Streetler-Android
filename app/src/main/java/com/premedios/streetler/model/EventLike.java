package com.premedios.streetler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by user on 12/02/2016.
 */

@Table(name = "EventLikes")
public class EventLike extends Model {
    @Column(name = "eventId")
    public Event eventId;

    @Column(name = "userId")
    public User userId;
}
