package com.ankit.theweatherapp.data.source.remote;

import com.ankit.theweatherapp.model.Main;
import com.ankit.theweatherapp.model.Test1;
import com.ankit.theweatherapp.model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServices {

    @GET("data/2.5/find")
    Call<Test1> getCurrentTemp(@Query("q") String city, @Query("appid") String api_key, @Query("units") String units);
}
