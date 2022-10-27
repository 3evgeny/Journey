package com.melself.journey.data;

import androidx.lifecycle.Transformations;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.melself.journey.data.model.Country;

@Entity(tableName = "countries")
public class DBCountry {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private long id;

    @ColumnInfo(name = "_name")
    private String name;

    @ColumnInfo(name = "_description")
    private String description;

    @ColumnInfo(name = "_price")
    private String price;

    @Ignore
    public DBCountry() {
    }

    public DBCountry(long id, String name, String description, String price) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public static DBCountry convertToDBCountry(Country country){
        DBCountry dbCountry = new DBCountry();
        dbCountry.setId(country.getId());
        dbCountry.setName(country.getName());
        dbCountry.setDescription(country.getDescription());
        dbCountry.setPrice(country.getPrice());
        return dbCountry;
    }

    public Country convertToCountry(){
        Country country = new Country();
        country.setId(this.getId());
        country.setName(this.getName());
        country.setDescription(this.getDescription());
        country.setPrice(this.getPrice());
        return country;
    }
}
