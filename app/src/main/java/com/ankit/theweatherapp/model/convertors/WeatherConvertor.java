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
        List<Weather> measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String measurementsToString(List<Weather> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Weather>>() {}.getType();
        String json = gson.toJson(list, type);
        return json;
    }
}
