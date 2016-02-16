package com.premedios.streetler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

import java.sql.Date;
import java.util.List;

/**
 * Created by user on 12/02/2016.
 */
public class User extends Model {

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "city")
    private String city;

    @Column(name = "dateofbirth")
    private Date dateoOfBirth;

    public List<EventImage> images() {
        return getMany(EventImage.class, "user");
    }

    public List<EventLike> likes() { return getMany(EventLike.class, "user"); }
}
