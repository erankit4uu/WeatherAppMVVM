package com.ankit.theweatherapp.data.source.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM List")
    List<com.ankit.theweatherapp.model.List> getAllData();

    @Insert
    void insertTemp(List<com.ankit.theweatherapp.model.List> list);
}
