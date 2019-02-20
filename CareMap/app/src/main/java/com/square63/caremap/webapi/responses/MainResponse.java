package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MainResponse implements Serializable {
    @SerializedName("results")
    private ResultResponse resultResponse;

    public ResultResponse getResultResponse() {
        return resultResponse;
    }

    public void setResultResponse(ResultResponse resultResponse) {
        this.resultResponse = resultResponse;
    }
}
