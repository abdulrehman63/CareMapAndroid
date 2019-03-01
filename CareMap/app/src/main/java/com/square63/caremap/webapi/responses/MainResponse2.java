package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.InterestModel;

import java.util.ArrayList;

public class MainResponse2 {
    @SerializedName("success")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @SerializedName("result")
    private GiverResultResponse resultResponse;

    public GiverResultResponse getResultResponse() {
        return resultResponse;
    }

    public void setResultResponse(GiverResultResponse resultResponse) {
        this.resultResponse = resultResponse;
    }
}
