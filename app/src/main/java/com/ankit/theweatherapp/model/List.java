
package com.ankit.theweatherapp.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.ankit.theweatherapp.model.convertors.WeatherConvertor;
import com.google.gson.annotations.SerializedName;

@Entity
@TypeConverters(WeatherConvertor.class)
public class List {

    @SerializedName("clouds")
    @Embedded
    private Clouds mClouds;
    @SerializedName("coord")
    @Embedded
    private Coord mCoord;
    @SerializedName("dt")
    private Long mDt;

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private Long id = 0L;

    @SerializedName("main")
    @Embedded
    private Main mMain;
    @SerializedName("name")
    private String mName;



//    @SerializedName("rain")
//    @Embedded
//    private Rain mRain;

    @SerializedName("snow")
    private String snow;
    @SerializedName("sys")
    @Embedded
    private Sys mSys;

    private java.util.List<Weather> weather;

    @SerializedName("wind")
    @Embedded
    private Wind mWind;

    public Clouds getClouds() {
        return mClouds;
    }

    public void setClouds(Clouds clouds) {
        mClouds = clouds;
    }

    public Coord getCoord() {
        return mCoord;
    }

    public void setCoord(Coord coord) {
        mCoord = coord;
    }

    public Long getDt() {
        return mDt;
    }

    public void setDt(Long dt) {
        mDt = dt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Main getMain() {
        return mMain;
    }

    public void setMain(Main main) {
        mMain = main;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }



    public Sys getSys() {
        return mSys;
    }

    public void setSys(Sys sys) {
        mSys = sys;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setWind(Wind wind) {
        mWind = wind;
    }
    public String getSnow() {
        return snow;
    }

    public void setSnow(String snow) {
        this.snow = snow;
    }
//    public Rain getmRain() {
//        return mRain;
//    }
//
//    public void setmRain(Rain mRain) {
//        this.mRain = mRain;
//    }
}
