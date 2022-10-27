package com.melself.journey.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.melself.journey.data.AppDatabase;
import com.melself.journey.data.DBTicket;
import com.melself.journey.data.TicketDAO;
import com.melself.journey.data.model.Ticket;

import java.util.List;

public class TicketRepository {

    private TicketDAO ticketDAO;
    private LiveData<List<DBTicket>> getAllTickets;
    private LiveData<DBTicket> getTicket;

    public TicketRepository(Application application){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ticketDAO = appDatabase.getTicketDAO();
    }

    public void insertTicket(Ticket ticket){
        DBTicket dbTicket = DBTicket.convertToTicket(ticket);
        AppDatabase.databaseWriteExecutor.execute(() -> {
            ticketDAO.insertTicket(dbTicket);
        });
    }

    public void updateTicket(Ticket ticket){
        DBTicket dbTicket = DBTicket.convertToTicket(ticket);
        AppDatabase.databaseWriteExecutor.execute(() -> {
            ticketDAO.updateTicket(dbTicket);
        });
    }

    public void deleteTicket(Ticket ticket){
        DBTicket dbTicket = DBTicket.convertToTicket(ticket);
        AppDatabase.databaseWriteExecutor.execute(() -> {
            ticketDAO.deleteTicket(dbTicket);
        });
    }

    public LiveData<List<DBTicket>> getAllTicketsLive(){
        return ticketDAO.getAllTickets();
    }

    public LiveData<DBTicket> getTicketLive(long id){
        return ticketDAO.getTicket(id);
    }
}
