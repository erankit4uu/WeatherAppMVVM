package com.ankit.theweatherapp.data.repo;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ankit.theweatherapp.achitecture.ArchitectureApp;
import com.ankit.theweatherapp.data.source.local.WeatherDao;
import com.ankit.theweatherapp.data.source.remote.WebServices;
import com.ankit.theweatherapp.model.Main;
import com.ankit.theweatherapp.model.Test1;
import com.ankit.theweatherapp.model.Weather;
import com.ankit.theweatherapp.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepo {
    MutableLiveData<List<com.ankit.theweatherapp.model.List>> data;
    Executor executor;
    WebServices webServices;
    ArchitectureApp architectureApp;
    WeatherDao weatherDao;
    List<com.ankit.theweatherapp.model.List> mainList;

    public WeatherRepo(Executor executor, WebServices webServices, WeatherDao weatherDao){
        this.executor = executor;
        this.webServices = webServices;
        this.weatherDao =weatherDao;
        data = new MutableLiveData<>();

    }

    @Inject
    public LiveData<List<com.ankit.theweatherapp.model.List>> getWeatherData(){
        executor.execute(() -> {
            mainList = weatherDao.getAllData();
            if (!mainList.isEmpty()) {
                List<com.ankit.theweatherapp.model.List> mainData = mainList;
                data.postValue(mainData);
            } else {
                webServices.getCurrentTemp("Delhi", Constants.API_KEY, "metric")
                        .enqueue(new Callback<Test1>() {
                            @Override
                            public void onResponse(@NotNull Call<Test1> call, @NotNull Response<Test1> response) {
                                assert response.body() != null;
                                Log.i("Temperature",response.body().getMlist().get(0).getMain().getTemp().toString());
                                executor.execute(() -> {
                                    mainList = response.body().getMlist();
                                    data.postValue(mainList);
                                });

                            }

                            @Override
                            public void onFailure(@NotNull Call<Test1> call, @NotNull Throwable t) {
                                Log.i("fail", t.getMessage());
//                                Toast.makeText(, t.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });

            }
        });
        return data;
    }
}
