package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.LanguageModel;

import java.util.ArrayList;

public class GetLanguagesResponse {
    public ArrayList<LanguageModel> getLanguageModelArrayList() {
        return languageModelArrayList;
    }

    public void setLanguageModelArrayList(ArrayList<LanguageModel> languageModelArrayList) {
        this.languageModelArrayList = languageModelArrayList;
    }

    @SerializedName("languages")

    private ArrayList<LanguageModel> languageModelArrayList;
}
