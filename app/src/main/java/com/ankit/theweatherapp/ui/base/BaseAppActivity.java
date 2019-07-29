package com.ankit.theweatherapp.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseAppActivity extends AppCompatActivity {
    ViewDataBinding bindingUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ViewDataBinding binding(int layout){
        bindingUtil = DataBindingUtil.setContentView(this, layout);
        return bindingUtil;
    }
}
