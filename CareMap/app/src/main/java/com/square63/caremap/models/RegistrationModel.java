package com.square63.caremap.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.square63.caremap.BR;

import java.io.Serializable;

public class RegistrationModel extends BaseObservable implements Serializable {
    private String email;
    private String password;
    private String userName;

    public String getUserName() {
        return userName;
    }
    @Bindable
    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

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
