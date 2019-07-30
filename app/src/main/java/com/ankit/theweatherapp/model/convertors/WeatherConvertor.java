package com.ankit.theweatherapp.model.convertors;

import androidx.room.TypeConverter;

import com.ankit.theweatherapp.model.Weather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class WeatherConvertor {
    @TypeConverter
    public static List<Weather> stringToMeasurements(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Weather>>() {}.getType();
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String measurementsToString(List<Weather> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Weather>>() {}.getType();
        return gson.toJson(list, type);
    }
}
