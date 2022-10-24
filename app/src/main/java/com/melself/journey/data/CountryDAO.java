package com.melself.journey.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CountryDAO {

    @Insert
    void insertCountry(DBCountry dbCountry);

    @Update
    void updateCountry(DBCountry dbCountry);

    @Delete
    void deleteCountry(DBCountry dbCountry);

    @Query("SELECT * FROM countries WHERE _id ==:id ")
    LiveData<DBCountry> getCountry(long id);

    @Query("SELECT * FROM countries")
    LiveData<List<DBCountry>> getAllCountries();
}
