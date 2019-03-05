package com.square63.caremap.models.seekerModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.LanguageModel;

import java.io.Serializable;

public class SeniorLanguageModel implements Serializable {
    public LanguageModel getLanguageModel() {
        return languageModel;
    }

    public void setLanguageModel(LanguageModel languageModel) {
        this.languageModel = languageModel;
    }

    @SerializedName("language")
    @Expose

    private LanguageModel languageModel;
}
