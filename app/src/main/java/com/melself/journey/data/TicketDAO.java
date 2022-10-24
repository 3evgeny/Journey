package com.melself.journey.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TicketDAO {

    @Insert
    void insertTicket(DBTicket dbTicket);

    @Update
    void updateTicket(DBTicket dbTicket);

    @Delete
    void deleteTicket(DBTicket dbTicket);

    @Query("SELECT * FROM tickets WHERE _id ==:id ")
    LiveData<DBTicket> getTicket(long id);

    @Query("SELECT * FROM countries")
    LiveData<List<DBTicket>> getAllTickets();
}
