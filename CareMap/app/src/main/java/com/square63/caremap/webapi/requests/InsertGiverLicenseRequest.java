package com.square63.caremap.webapi.requests;

public class InsertGiverLicenseRequest {

    private String CaregiverID;
    private String License;
    private String Credantal;
    private String Documentfile;
    private String Requestdocument;
    private String IssueDate;
    private String ExpireDate;

    public String getCaregiverID() {
        return CaregiverID;
    }

    public void setCaregiverID(String caregiverID) {
        CaregiverID = caregiverID;
    }

    public String getLicense() {
        return License;
    }

    public void setLicense(String license) {
        License = license;
    }

    public String getCredantal() {
        return Credantal;
    }

    public void setCredantal(String credantal) {
        Credantal = credantal;
    }

    public String getDocumentfile() {
        return Documentfile;
    }

    public void setDocumentfile(String documentfile) {
        Documentfile = documentfile;
    }

    public String getRequestdocument() {
        return Requestdocument;
    }

    public void setRequestdocument(String requestdocument) {
        Requestdocument = requestdocument;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }

    public String getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(String expireDate) {
        ExpireDate = expireDate;
    }
}
