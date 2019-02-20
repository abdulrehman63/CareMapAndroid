package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MainResponse  implements Serializable {

    @SerializedName("success")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @SerializedName("result")
    private ResultResponse resultResponse;

    public ResultResponse getResultResponse() {
        return resultResponse;
    }

    public void setResultResponse(ResultResponse resultResponse) {
        this.resultResponse = resultResponse;
    }
}
