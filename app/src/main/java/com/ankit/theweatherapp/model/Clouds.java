
package com.ankit.theweatherapp.model;

import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    private Long mAll;

    public Long getAll() {
        return mAll;
    }

    public void setAll(Long all) {
        mAll = all;
    }

}
