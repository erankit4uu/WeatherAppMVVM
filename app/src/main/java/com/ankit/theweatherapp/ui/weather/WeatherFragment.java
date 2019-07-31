package com.ankit.theweatherapp.ui.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ankit.theweatherapp.R;
import com.ankit.theweatherapp.databinding.WeatherFragmentBinding;
import com.ankit.theweatherapp.ui.base.BaseAppFragment;

public class WeatherFragment extends BaseAppFragment {
    private WeatherViewModel viewModel;
    public  WeatherViewModelFactory weatherViewModelFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        WeatherFragmentBinding binding = (WeatherFragmentBinding) binding(inflater, container, R.layout.weather_fragment);

        weatherViewModelFactory = new WeatherViewModelFactory(getActivity());

        viewModel = ViewModelProviders.of(this, weatherViewModelFactory).get(WeatherViewModel.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        binding.rvHour.setLayoutManager(linearLayoutManager);

        viewModel.weatherList.observe(this, list -> {
            if (list!=null || !list.isEmpty()) {
                binding.tvTemp.setText(String.valueOf(list.get(0).getMain().getTemp()));
                Log.i("list", list.get(0).getMain().getTemp().toString());
                binding.rvHour.setAdapter(new HourlyDataAdapter(list));
            }
        });
//        viewModel.hourlyList.observe(this, lists ->
//        {
//            if (lists!=null || !lists.isEmpty()) {
//                binding.rvHour.setAdapter(new HourlyDataAdapter(lists));
//
//            }
//            });

        return binding.getRoot();

    }

}
