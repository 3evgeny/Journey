package com.melself.journey.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DBCountry.class, DBTicket.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final int NUMBER_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_THREADS);

    public abstract CountryDAO getCountryDAO();
    public abstract TicketDAO getTicketDAO();

    private static volatile AppDatabase INSTANCE;
    public static AppDatabase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (AppDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "JourneyDB").build();
                }
            }
        }
        return INSTANCE;
    }
}
