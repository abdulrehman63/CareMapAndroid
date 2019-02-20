package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GenericResponse implements Serializable {
    @SerializedName("success")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
