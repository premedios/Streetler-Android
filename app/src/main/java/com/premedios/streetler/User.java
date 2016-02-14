package com.premedios.streetler;

import java.sql.Date;

/**
 * Created by user on 12/02/2016.
 */
public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String city;
    private Date dateofbirth;

    public User() {

    }

    public User(int id, String firstname, String lastname, String city, Date dateofbirth) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.dateofbirth = dateofbirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

}
