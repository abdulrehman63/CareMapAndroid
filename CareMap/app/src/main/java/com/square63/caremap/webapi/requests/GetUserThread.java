package com.square63.caremap.webapi.requests;

import com.google.gson.annotations.SerializedName;

public class GetUserThread  {
    @SerializedName("UserId")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @SerializedName("option")
    private String option;
}
