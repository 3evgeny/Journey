package com.melself.journey.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tickets")
public class DBTicket {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private long id;

    @ColumnInfo(name = "_number")
    private String name;

    @ColumnInfo(name = "_country")
    private String country;

    @ColumnInfo(name = "_hotel")
    private String hotel;

    @ColumnInfo(name = "_date")
    private String date;

    @ColumnInfo(name = "_status")
    private String price;

    @Ignore
    public DBTicket() {
    }

    public DBTicket(long id, String name, String country, String hotel, String date, String price) {
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
