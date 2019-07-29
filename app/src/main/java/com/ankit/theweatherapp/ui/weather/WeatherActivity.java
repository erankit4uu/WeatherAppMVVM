package com.ankit.theweatherapp.ui.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.ankit.theweatherapp.R;
import com.ankit.theweatherapp.databinding.ActivityMainBinding;
import com.ankit.theweatherapp.ui.base.BaseAppActivity;


public class WeatherActivity extends BaseAppActivity {

    ActivityMainBinding mainBinding;

    WeatherViewModel viewModel;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = (ActivityMainBinding) binding(R.layout.activity_main);

       fragment = new WeatherFragment();
       fragmentTransaction(fragment);

    }

    private void fragmentTransaction(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
