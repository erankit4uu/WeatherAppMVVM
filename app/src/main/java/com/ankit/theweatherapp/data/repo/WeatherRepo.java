package com.ankit.theweatherapp.data.repo;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ankit.theweatherapp.data.source.local.WeatherDao;
import com.ankit.theweatherapp.data.source.remote.RetrofitClient;
import com.ankit.theweatherapp.data.source.remote.WebServices;
import com.ankit.theweatherapp.model.Test1;
import com.ankit.theweatherapp.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepo {
    private MutableLiveData<List<com.ankit.theweatherapp.model.List>> data;
    private MutableLiveData<List<com.ankit.theweatherapp.model.List>> hourlyData;
    private Executor executor;
    private WebServices webServices;
    private WeatherDao weatherDao;
    private List<com.ankit.theweatherapp.model.List> mainList;
    private final String UNITS = "metric";
    private final String CITY = "Delhi";

    public WeatherRepo(Executor executor, WeatherDao weatherDao, WebServices webServices){
        this.executor = executor;
        this.weatherDao =weatherDao;
        this.webServices = webServices;
        data = new MutableLiveData<>();
        hourlyData = new MutableLiveData<>();
    }

    public WeatherRepo() {

    }

    public LiveData<List<com.ankit.theweatherapp.model.List>> getCurrentData(){
        executor.execute(() -> {
            mainList = weatherDao.getAllData();
//            if (!mainList.isEmpty()) {
//                List<com.ankit.theweatherapp.model.List> mainData = mainList;
//                Log.d("data from db", mainData.get(0).getName());
//                data.postValue(mainData);
//            } else {
                webServices.getCurrentTemp(CITY, Constants.API_KEY, UNITS)
                        .enqueue(new Callback<Test1>() {
                            @Override
                            public void onResponse(@NotNull Call<Test1> call, @NotNull Response<Test1> response) {
                                assert response.body() != null;
                                Log.i("Temperature",response.body().getMlist().get(0).getMain().getTemp().toString());
                                executor.execute(() -> {
                                    mainList = response.body().getMlist();
//                                    weatherDao.insertTemp(response.body().getMlist());
                                    data.postValue(mainList);
                                });

                            }

                            @Override
                            public void onFailure(@NotNull Call<Test1> call, @NotNull Throwable t) {
                                Log.i("fail", t.getMessage());
                            }
                        });
//            }
        });
        return data;
    }

    public LiveData<List<com.ankit.theweatherapp.model.List>> getHourlyData(){
        executor.execute(() -> {
//            mainList = weatherDao.getAllData();
//            if (!mainList.isEmpty()) {
//                List<com.ankit.theweatherapp.model.List> mainData = mainList;
//                Log.d("data from db", mainData.get(0).getName());
//                data.postValue(mainData);
//            } else {
                webServices.getTempHourly("110017,IN", Constants.API_KEY, UNITS)
                        .enqueue(new Callback<Test1>() {
                            @Override
                            public void onResponse(@NotNull Call<Test1> call, @NotNull Response<Test1> response) {
                                Log.i("Temperature",response.body().getMlist().get(0).getMain().getTemp().toString());
                                executor.execute(() -> {
                                    mainList = response.body().getMlist();
//                                    weatherDao.insertTemp(response.body().getMlist());
                                    hourlyData.postValue(mainList);
                                });

                            }

                            @Override
                            public void onFailure(@NotNull Call<Test1> call, @NotNull Throwable t) {
                                Log.i("fail", t.getMessage());
                            }
                        });
//            }
        });
        return hourlyData;
    }


}
