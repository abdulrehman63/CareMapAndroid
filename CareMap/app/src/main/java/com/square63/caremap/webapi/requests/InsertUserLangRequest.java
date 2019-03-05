package com.square63.caremap.webapi.requests;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.utils.PreferenceHelper;

import java.io.Serializable;

public class InsertUserLangRequest implements Serializable {
    @SerializedName("UserID")
    private String userID = PreferenceHelper.getInstance().getString(Constants.USER_ID,"");
    @SerializedName("SeniorID")
    private String seniorID = PreferenceHelper.getInstance().getString(Constants.SENIOR_ID,"");
    @SerializedName("LanguageID")
    private String languageID;

    public String getSeniorID() {
        return seniorID;
    }

    public void setSeniorID(String seniorID) {
        this.seniorID = seniorID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLanguageID() {
        return languageID;
    }

    public void setLanguageID(String languageID) {
        this.languageID = languageID;
    }



}
