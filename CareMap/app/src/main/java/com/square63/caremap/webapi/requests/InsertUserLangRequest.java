package com.square63.caremap.webapi.requests;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InsertUserLangRequest implements Serializable {
    @SerializedName("UserID")
    private String userID;
    @SerializedName("LanguageID")
    private String languageID;

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
