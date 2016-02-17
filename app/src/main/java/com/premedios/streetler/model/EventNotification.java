package com.premedios.streetler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by user on 12/02/2016.
 */

@Table(name = "EventNotifications")
public class EventNotification extends Model {

    @Column(name = "type")
    public String type;

    @Column(name = "userId")
    public User userId;
}
