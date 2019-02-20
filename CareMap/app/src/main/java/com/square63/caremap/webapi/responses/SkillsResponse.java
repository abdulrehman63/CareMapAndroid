package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.webapi.ResponseResults.SkillsResults;

import java.io.Serializable;

public class SkillsResponse implements Serializable{
    @SerializedName("results")
    private SkillsResults skillsResults;

    public SkillsResults getSkillsResults() {
        return skillsResults;
    }

    public void setSkillsResults(SkillsResults skillsResults) {
        this.skillsResults = skillsResults;
    }
}
