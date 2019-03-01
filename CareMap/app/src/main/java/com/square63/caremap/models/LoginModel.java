package com.square63.caremap.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.square63.caremap.BR;

import java.io.Serializable;

public class LoginModel extends BaseObservable implements Serializable {
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Password")
    @Expose
    private String password;

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    @SerializedName("RememberMe")
    @Expose
    private String rememberMe = "false";


    public String getEmail() {
        return email;
    }
    @Bindable
    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);

    }

    public String getPassword() {
        return password;
    }
    @Bindable
    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
