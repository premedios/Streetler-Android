package com.premedios.streetler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by user on 12/02/2016.
 */

@Table(name = "Events")

public class Event extends Model {

    @Column(name = "type")
    public String type;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "imageURL")
    public String imageURL;

    @Column(name = "latitude")
    public String latitude;

    @Column(name = "longitude")
    public String longitude;
}
