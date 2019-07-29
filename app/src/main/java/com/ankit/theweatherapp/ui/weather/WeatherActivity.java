package com.ankit.theweatherapp.ui.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ankit.theweatherapp.R;
import com.ankit.theweatherapp.databinding.ActivityMainBinding;
import com.ankit.theweatherapp.model.List;
import com.ankit.theweatherapp.ui.base.BaseAppActivity;


public class WeatherActivity extends BaseAppActivity {

    ActivityMainBinding mainBinding;

    WeatherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = (ActivityMainBinding) binding(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this, new WeatherViewModelFactory()).get(WeatherViewModel.class);
        viewModel.weatherList.observe(this, list -> {
            if (list!=null || !list.isEmpty()) {
                Log.i("list", list.get(0).getTempMax().toString());
            }
        });
    }
}
