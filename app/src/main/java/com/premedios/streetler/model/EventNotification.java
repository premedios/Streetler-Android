package com.premedios.streetler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by user on 12/02/2016.
 */
public class EventNotification extends Model {

    @Column(name = "type")
    public String type;

    @Column(name = "userId")
    public User userId;
}
