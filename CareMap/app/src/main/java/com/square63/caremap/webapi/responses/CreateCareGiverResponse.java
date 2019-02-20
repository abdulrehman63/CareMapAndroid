package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateCareGiverResponse extends GenericResponse implements Serializable {
      private String id;
      private String id2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }
}
