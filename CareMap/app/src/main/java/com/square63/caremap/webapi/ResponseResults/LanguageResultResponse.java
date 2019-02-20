package com.square63.caremap.webapi.ResponseResults;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.webapi.responses.GetLanguagesResponse;

import java.io.Serializable;

public class LanguageResultResponse implements Serializable {
    @SerializedName("result")
    private GetLanguagesResponse languagesResponse;

    public GetLanguagesResponse getLanguagesResponse() {
        return languagesResponse;
    }

    public void setLanguagesResponse(GetLanguagesResponse languagesResponse) {
        this.languagesResponse = languagesResponse;
    }
}
