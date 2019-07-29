package com.ankit.theweatherapp.ui.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.ankit.theweatherapp.R;
import com.ankit.theweatherapp.databinding.WeatherFragmentBinding;
import com.ankit.theweatherapp.ui.base.BaseAppFragment;

public class WeatherFragment extends BaseAppFragment {
    private WeatherViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        WeatherFragmentBinding binding = (WeatherFragmentBinding) binding(inflater, container, R.layout.weather_fragment);

        viewModel = ViewModelProviders.of(this, new WeatherViewModelFactory()).get(WeatherViewModel.class);

        viewModel.weatherList.observe(this, list -> {
            if (list!=null || !list.isEmpty()) {
                binding.tvTemp.setText(String.valueOf(list.get(0).getMain().getTemp()));
                Log.i("list", list.get(0).getMain().getTemp().toString());
            }
        });

        return binding.getRoot();

    }

}
