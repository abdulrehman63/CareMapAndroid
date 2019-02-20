package com.square63.caremap.webapi.requests;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InsertUserInterestRequest implements Serializable{

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getInterestID() {
        return InterestID;
    }

    public void setInterestID(String interestID) {
        InterestID = interestID;
    }

    @SerializedName("UserID")

    private String userID;
    @SerializedName("InterestID")
    private String InterestID;
}
