
package com.ankit.theweatherapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Test1 {

    @SerializedName("message")
    private String message;

    @SerializedName("cod")
    private String cod;

    @SerializedName("count")
    private int count;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<com.ankit.theweatherapp.model.List> getMlist() {
        return list;
    }

    public void setMlist(List<com.ankit.theweatherapp.model.List> mlist) {
        this.list = mlist;
    }

    private List<com.ankit.theweatherapp.model.List> list;

}
