package com.ankit.theweatherapp.achitecture.di;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.ankit.theweatherapp.achitecture.ArchitectureApp;
import com.ankit.theweatherapp.data.repo.WeatherRepo;
import com.ankit.theweatherapp.data.source.local.AppDatabase;
import com.ankit.theweatherapp.data.source.local.WeatherDao;
import com.ankit.theweatherapp.data.source.remote.RetrofitClient;
import com.ankit.theweatherapp.ui.base.BaseAppActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AppModule {

    private ArchitectureApp application;
    private BaseAppActivity activity;


    public AppModule(ArchitectureApp application) {
        this.application = application;
    }

    public AppModule(BaseAppActivity activity){
        this.activity = activity;
    }

    @Provides
    @Singleton
    public ArchitectureApp provideArchitecture() {
        return application;
    }

    @Provides
    @Singleton
    public BaseAppActivity provideActivity(){
        return activity;
    }


    @Singleton
    @Provides
    public Application provideApplication() {
        return application;
    }



    @Provides
    @Singleton
    public WeatherDao provideItemDao(AppDatabase appDatabase){
        return appDatabase.weatherDao();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(RetrofitClient retrofitClient){
        return RetrofitClient.getClient();
    }

    @Provides
    @Singleton
    public AppDatabase provideDatabase(){
        //TODO remove allow main thread and use asynchronous query
        return Room.databaseBuilder(application, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries().build();
    }

}
