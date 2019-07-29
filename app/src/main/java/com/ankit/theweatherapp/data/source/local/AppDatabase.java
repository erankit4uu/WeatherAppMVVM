package com.ankit.theweatherapp.data.source.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ankit.theweatherapp.model.Main;

import javax.inject.Inject;

@Database(entities = {Main.class}, version = 2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract WeatherDao weatherDao();
    public static AppDatabase instance = null;
    private final static String lock = "lock";
    public final static String DB_NAME = "TheWeatherApp.db";

    public static AppDatabase getInstance(Context context){
        synchronized (lock){
            if (instance == null){
                instance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase.class,
                        DB_NAME
                ).fallbackToDestructiveMigration().build();
            }
        }
        return instance;
    }
}
