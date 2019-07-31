package com.ankit.theweatherapp.ui.base;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.ankit.theweatherapp.achitecture.ArchitectureApp;

public abstract class BaseViewModel extends ViewModel {
    BaseAppActivity activity;
    BaseAppFragment fragment;



    public BaseViewModel(Context context){
        this.activity = (BaseAppActivity) context;

        ArchitectureApp.applicationComponent.inject(activity);
    }

    public BaseViewModel(BaseAppFragment fragment){
        this.fragment = fragment;
        ArchitectureApp.applicationComponent.inject(fragment);
    }

    public BaseViewModel(){

    }

}
