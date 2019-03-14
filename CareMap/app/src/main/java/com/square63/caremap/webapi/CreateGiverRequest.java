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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    private String Id;
    @SerializedName("User")

    private RegistrationModel registrationModel;
}
