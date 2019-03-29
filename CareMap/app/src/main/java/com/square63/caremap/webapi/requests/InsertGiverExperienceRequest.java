package com.square63.caremap.webapi.requests;

public class InsertGiverExperienceRequest {

    private String CaregiverID;
    private String FromDate;
    private String ToDate;
    private String Years;
    private String TitlePosition;
    private String Employer;
    private String AvailabilityDistance;

    public String getAvailabilityDistance() {
        return AvailabilityDistance;
    }

    public void setAvailabilityDistance(String availabilityDistance) {
        AvailabilityDistance = availabilityDistance;
    }

    public String getDesiredWage() {
        return DesiredWage;
    }

    public void setDesiredWage(String desiredWage) {
        DesiredWage = desiredWage;
    }



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

    public String getYears() {
        return Years;
    }

    public void setYears(String years) {
        Years = years;
    }

    public String getToDate() {
        return ToDate;
    }

    public void setToDate(String toDate) {
        ToDate = toDate;
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
    private String DesiredWage;
    private String Description;
}
