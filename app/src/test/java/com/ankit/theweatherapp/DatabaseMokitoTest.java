package com.ankit.theweatherapp;



import com.ankit.theweatherapp.data.source.local.AppDatabase;
import com.ankit.theweatherapp.data.source.local.WeatherDao;
import com.ankit.theweatherapp.data.source.remote.WebServices;
import com.ankit.theweatherapp.utils.Constants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;


import retrofit2.Callback;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseMokitoTest {

    @Mock
    AppDatabase database;

    @Mock
    WeatherDao weatherDao;


    @Test
    public void shouldDoSomething() {
        verify(database);
//        when(weatherDao.getAllData()).thenAnswer(i -> {
//            int id = i.getArgument(0);
//            return id;
//        });
    }

    @Test
    public final void callbackTest() {
        WebServices service = mock(WebServices.class);
        when(service.getCurrentTemp("delhi", Constants.API_KEY, "metric")).thenAnswer(i -> {
            Callback callback = i.getArgument(0);
            callback.notify();
            return null;
        });
    }
}
