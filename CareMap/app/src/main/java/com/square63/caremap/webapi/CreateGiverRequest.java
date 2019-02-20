package com.square63.caremap.webapi;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.RegistrationModel;

import java.io.Serializable;

public class CreateGiverRequest implements Serializable {
    public RegistrationModel getRegistrationModel() {
        return registrationModel;
    }

    public void setRegistrationModel(RegistrationModel registrationModel) {
        this.registrationModel = registrationModel;
    }

    @SerializedName("User")

    private RegistrationModel registrationModel;
}
