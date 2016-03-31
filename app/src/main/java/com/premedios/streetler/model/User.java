package com.premedios.streetler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.sql.Date;
import java.util.List;

/**
 * Created by Pedro Remedios on 12/02/2016.
 */

@Table(name="User")
public class User extends Model {

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "city")
    private String city;

    @Column(name = "dateofbirth")
    private Date dateoOfBirth;

    public List<EventImage> images() { return getMany(EventImage.class, "userId"); }

    public List<EventVideo> videos() { return getMany(EventVideo.class, "userId"); }

    public List<EventLike> likes() { return getMany(EventLike.class, "userId"); }

    public List<EventNotification> notifications() { return getMany(EventNotification.class, "userId"); }
}
