package com.square63.caremap.webapi.requests;

public class InsertGiverExperienceRequest {

    private String CaregiverID;
    private String FromDate;
    private String ToDate;
    private int Years;
    private String TitlePosition;
    private String Employer;

    public String getCaregiverID() {
        return CaregiverID;
    }

    public void setCaregiverID(String caregiverID) {
        CaregiverID = caregiverID;
    }

    public String getFromDate() {
        return FromDate;
    }

    public void setFromDate(String fromDate) {
        FromDate = fromDate;
    }

    public String getToDate() {
        return ToDate;
    }

    public void setToDate(String toDate) {
        ToDate = toDate;
    }

    public int getYears() {
        return Years;
    }

    public void setYears(int years) {
        Years = years;
    }

    public String getTitlePosition() {
        return TitlePosition;
    }

    public void setTitlePosition(String titlePosition) {
        TitlePosition = titlePosition;
    }

    public String getEmployer() {
        return Employer;
    }

    public void setEmployer(String employer) {
        Employer = employer;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String Description;
}
