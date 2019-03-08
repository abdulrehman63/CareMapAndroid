
package com.square63.caremap.models.giverModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("nationality")
    @Expose
    private Object nationality;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("userRole")
    @Expose
    private UserRole userRole;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("registrationDate")
    @Expose
    private String registrationDate;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("countryID")
    @Expose
    private String countryID;
    @SerializedName("stateID")
    @Expose
    private String stateID;
    @SerializedName("nationalityID")
    @Expose
    private String nationalityID;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("contactDetails")
    @Expose
    private Object contactDetails;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("hasPicture")
    @Expose
    private String hasPicture;
    @SerializedName("profileDescription")
    @Expose
    private Object profileDescription;
    @SerializedName("otherInterests")
    @Expose
    private Object otherInterests;
    @SerializedName("otherLanguage")
    @Expose
    private Object otherLanguage;
    @SerializedName("activationLink")
    @Expose
    private String activationLink;
    @SerializedName("resetPasswordLink")
    @Expose
    private Object resetPasswordLink;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("facebookId")
    @Expose
    private Object facebookId;
    @SerializedName("facebookName")
    @Expose
    private Object facebookName;
    @SerializedName("tweeterId")
    @Expose
    private Object tweeterId;
    @SerializedName("tweeterName")
    @Expose
    private Object tweeterName;
    @SerializedName("googleId")
    @Expose
    private Object googleId;
    @SerializedName("googleName")
    @Expose
    private Object googleName;
    @SerializedName("userRoleID")
    @Expose
    private String userRoleID;
    @SerializedName("hashPassword")
    @Expose
    private String hashPassword;
    @SerializedName("percentComplete")
    @Expose
    private Object percentComplete;
    @SerializedName("vetted")
    @Expose
    private Object vetted;
    @SerializedName("activationDate")
    @Expose
    private Object activationDate;
    @SerializedName("emailSent")
    @Expose
    private Integer emailSent;
    @SerializedName("points")
    @Expose
    private Object points;
    @SerializedName("referCode")
    @Expose
    private Object referCode;

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getNationality() {
        return nationality;
    }

    public void setNationality(Object nationality) {
        this.nationality = nationality;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getStateID() {
        return stateID;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    public String getNationalityID() {
        return nationalityID;
    }

    public void setNationalityID(String nationalityID) {
        this.nationalityID = nationalityID;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Object getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Object contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(String hasPicture) {
        this.hasPicture = hasPicture;
    }

    public Object getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(Object profileDescription) {
        this.profileDescription = profileDescription;
    }

    public Object getOtherInterests() {
        return otherInterests;
    }

    public void setOtherInterests(Object otherInterests) {
        this.otherInterests = otherInterests;
    }

    public Object getOtherLanguage() {
        return otherLanguage;
    }

    public void setOtherLanguage(Object otherLanguage) {
        this.otherLanguage = otherLanguage;
    }

    public String getActivationLink() {
        return activationLink;
    }

    public void setActivationLink(String activationLink) {
        this.activationLink = activationLink;
    }

    public Object getResetPasswordLink() {
        return resetPasswordLink;
    }

    public void setResetPasswordLink(Object resetPasswordLink) {
        this.resetPasswordLink = resetPasswordLink;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Object getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(Object facebookId) {
        this.facebookId = facebookId;
    }

    public Object getFacebookName() {
        return facebookName;
    }

    public void setFacebookName(Object facebookName) {
        this.facebookName = facebookName;
    }

    public Object getTweeterId() {
        return tweeterId;
    }

    public void setTweeterId(Object tweeterId) {
        this.tweeterId = tweeterId;
    }

    public Object getTweeterName() {
        return tweeterName;
    }

    public void setTweeterName(Object tweeterName) {
        this.tweeterName = tweeterName;
    }

    public Object getGoogleId() {
        return googleId;
    }

    public void setGoogleId(Object googleId) {
        this.googleId = googleId;
    }

    public Object getGoogleName() {
        return googleName;
    }

    public void setGoogleName(Object googleName) {
        this.googleName = googleName;
    }

    public String getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(String userRoleID) {
        this.userRoleID = userRoleID;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public Object getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(Object percentComplete) {
        this.percentComplete = percentComplete;
    }

    public Object getVetted() {
        return vetted;
    }

    public void setVetted(Object vetted) {
        this.vetted = vetted;
    }

    public Object getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Object activationDate) {
        this.activationDate = activationDate;
    }

    public Integer getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(Integer emailSent) {
        this.emailSent = emailSent;
    }

    public Object getPoints() {
        return points;
    }

    public void setPoints(Object points) {
        this.points = points;
    }

    public Object getReferCode() {
        return referCode;
    }

    public void setReferCode(Object referCode) {
        this.referCode = referCode;
    }

    public Object getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(Object referredBy) {
        this.referredBy = referredBy;
    }

    @SerializedName("referredBy")
    @Expose
    private Object referredBy;



}
