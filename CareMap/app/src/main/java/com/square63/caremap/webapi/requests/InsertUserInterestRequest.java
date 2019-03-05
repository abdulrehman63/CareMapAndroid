package com.square63.caremap.webapi.requests;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.utils.PreferenceHelper;

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
    private String userID = PreferenceHelper.getInstance().getString(Constants.USER_ID,"");;
    @SerializedName("InterestID")
    private String InterestID;
    @SerializedName("SeniorID")
    private String seniorID = PreferenceHelper.getInstance().getString(Constants.SENIOR_ID,"");

    public String getSeniorID() {
        return seniorID;
    }

    public void setSeniorID(String seniorID) {
        this.seniorID = seniorID;
    }
}
