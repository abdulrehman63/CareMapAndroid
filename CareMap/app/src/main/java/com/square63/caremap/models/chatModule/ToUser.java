
package com.square63.caremap.models.chatModule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.giverModels.UserRole;

import java.io.Serializable;

public class ToUser implements Serializable{

    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("nationality")
    @Expose
    private Object nationality;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("userRole")
    @Expose
    private UserRole userRole;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("registrationDate")
    @Expose
    private Object registrationDate;
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
    private Object dateOfBirth;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("address2")
    @Expose
    private Object address2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("countryID")
    @Expose
    private Object countryID;
    @SerializedName("stateID")
    @Expose
    private Object stateID;
    @SerializedName("nationalityID")
    @Expose
    private Object nationalityID;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("contactDetails")
    @Expose
    private Object contactDetails;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("hasPicture")
    @Expose
    private Integer hasPicture;
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
    private Object emailSent;
    @SerializedName("points")
    @Expose
    private Object points;
    @SerializedName("referCode")
    @Expose
    private String referCode;
    @SerializedName("referredBy")
    @Expose
    private Object referredBy;

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

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
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

    public Object getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Object registrationDate) {
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

    public Object getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Object dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getAddress2() {
        return address2;
    }

    public void setAddress2(Object address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object getCountryID() {
        return countryID;
    }

    public void setCountryID(Object countryID) {
        this.countryID = countryID;
    }

    public Object getStateID() {
        return stateID;
    }

    public void setStateID(Object stateID) {
        this.stateID = stateID;
    }

    public Object getNationalityID() {
        return nationalityID;
    }

    public void setNationalityID(Object nationalityID) {
        this.nationalityID = nationalityID;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
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

    public Integer getHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(Integer hasPicture) {
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

    public Object getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(Object emailSent) {
        this.emailSent = emailSent;
    }

    public Object getPoints() {
        return points;
    }

    public void setPoints(Object points) {
        this.points = points;
    }

    public String getReferCode() {
        return referCode;
    }

    public void setReferCode(String referCode) {
        this.referCode = referCode;
    }

    public Object getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(Object referredBy) {
        this.referredBy = referredBy;
    }

}
