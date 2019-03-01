
package com.square63.caremap.models.giverModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("caregivers")
    @Expose
    private List<Caregiver> caregivers = null;
    @SerializedName("totalRecords")
    @Expose
    private Integer totalRecords;
    @SerializedName("resultsNo")
    @Expose
    private Integer resultsNo;

    public List<Caregiver> getCaregivers() {
        return caregivers;
    }

    public void setCaregivers(List<Caregiver> caregivers) {
        this.caregivers = caregivers;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getResultsNo() {
        return resultsNo;
    }

    public void setResultsNo(Integer resultsNo) {
        this.resultsNo = resultsNo;
    }

}
