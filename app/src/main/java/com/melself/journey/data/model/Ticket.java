package com.melself.journey.data.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Ticket {
    private long id;
    private String name;
    private String country;
    private String hotel;
    private String date;
    private String price;

    public Ticket() {
    }

    public Ticket(long id, String name, String country, String hotel, String date, String price) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.hotel = hotel;
        this.date = date;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
