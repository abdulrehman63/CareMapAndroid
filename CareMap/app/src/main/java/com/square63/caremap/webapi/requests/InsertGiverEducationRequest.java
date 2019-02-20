package com.square63.caremap.webapi.requests;

import java.io.Serializable;

public class InsertGiverEducationRequest implements Serializable {
    private String CaregiverID;
    private String StartDate;
    private String EndDate;
    private String Field;

    public String getCaregiverID() {
        return CaregiverID;
    }

    public void setCaregiverID(String caregiverID) {
        CaregiverID = caregiverID;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getField() {
        return Field;
    }

    public void setField(String field) {
        Field = field;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    private String College;
}
