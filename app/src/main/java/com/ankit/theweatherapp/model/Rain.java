package com.ankit.theweatherapp.model;

import com.google.gson.annotations.SerializedName;

public class Rain {
    public Double getH1() {
        return h1;
    }

    public void setH1(Double h1) {
        this.h1 = h1;
    }

    @SerializedName("1h")
    private Double h1;
}
