package com.ankit.theweatherapp.data.source.local;

import androidx.room.Dao;
import androidx.room.Query;


import com.ankit.theweatherapp.model.Main;
import com.ankit.theweatherapp.model.Weather;

import java.util.List;



@Dao
public interface WeatherDao {

    @Query("SELECT * FROM Main")
    List<Main> getAllData();
}
