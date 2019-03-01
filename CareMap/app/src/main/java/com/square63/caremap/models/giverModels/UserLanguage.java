
package com.square63.caremap.models.giverModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLanguage {

    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("languageID")
    @Expose
    private String languageID;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("language")
    @Expose
    private Language language;
    @SerializedName("id")
    @Expose
    private String id;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
