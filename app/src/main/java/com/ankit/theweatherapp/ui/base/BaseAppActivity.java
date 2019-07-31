package com.ankit.theweatherapp.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.ankit.theweatherapp.achitecture.ApplicationComponent;


public abstract class BaseAppActivity extends AppCompatActivity {
    ViewDataBinding bindingUtil;
    ApplicationComponent component;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        component.inject(this);
    }

    public ViewDataBinding binding(int layout){
        bindingUtil = DataBindingUtil.setContentView(this, layout);
        return bindingUtil;
    }
}
