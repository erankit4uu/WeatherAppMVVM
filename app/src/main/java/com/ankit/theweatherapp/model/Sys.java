
package com.ankit.theweatherapp.model;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("country")
    private String mCountry;



//    @SerializedName("id")
//    private Long sId;
    @SerializedName("message")
    private Double mMessage;
    @SerializedName("sunrise")
    private Long mSunrise;
    @SerializedName("sunset")
    private Long mSunset;
    @SerializedName("type")
    private Long mType;

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public Double getMessage() {
        return mMessage;
    }

    public void setMessage(Double message) {
        mMessage = message;
    }

    public Long getSunrise() {
        return mSunrise;
    }

    public void setSunrise(Long sunrise) {
        mSunrise = sunrise;
    }

    public Long getSunset() {
        return mSunset;
    }

    public void setSunset(Long sunset) {
        mSunset = sunset;
    }

    public Long getType() {
        return mType;
    }

    public void setType(Long type) {
        mType = type;
    }
//    public Long getsId() {
//        return sId;
//    }
//
//    public void setsId(Long sId) {
//        this.sId = sId;
//    }

}
