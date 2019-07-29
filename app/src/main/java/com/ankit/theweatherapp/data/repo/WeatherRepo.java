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

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepo {
    MutableLiveData<List<Main>> data;
    Executor executor;
    WebServices webServices;
    ArchitectureApp architectureApp;
    WeatherDao weatherDao;
    List<Main> mainList;

    public WeatherRepo(Executor executor, WebServices webServices, WeatherDao weatherDao){
        this.executor = executor;
        this.webServices = webServices;
        this.weatherDao =weatherDao;
        data = new MutableLiveData<>();

    }

    @Inject
    public LiveData<List<Main>> getWeatherData(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mainList = weatherDao.getAllData();
                if (!mainList.isEmpty()) {
                    List<Main> mainData = mainList;
                    data.postValue(mainData);
                } else {
                    webServices.getCurrentTemp("Delhi", Constants.API_KEY)
                            .enqueue(new Callback<Test1>() {
                                @Override
                                public void onResponse(@NotNull Call<Test1> call, @NotNull Response<Test1> response) {
                                    assert response.body() != null;
                                    Log.i("Temp",response.body().getMlist().get(0).getMain().getTemp().toString());

                                }

                                @Override
                                public void onFailure(@NotNull Call<Test1> call, @NotNull Throwable t) {
                                    Log.i("fail", t.getMessage());
//                                Toast.makeText(, t.getMessage(),Toast.LENGTH_LONG).show();
                                }
                            });

                }
            }
        });
        return data;
    }
}
