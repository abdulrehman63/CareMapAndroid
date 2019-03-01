
package com.square63.caremap.webapi.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilterCaregiver {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("UserId")
    @Expose
    private String userId;
    @SerializedName("City")
    @Expose
    private String city;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @SerializedName("State")
    @Expose
    private String state;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



}
