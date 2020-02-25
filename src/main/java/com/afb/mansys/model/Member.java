package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class Member {
    private final UUID id;
    private final String name;
    private final String personalID;
    private final String sex;
    private final Date registerDate;
    private final String membershipID;
    private String major;
    private String photo;
    private String phoneNumber;
    private String region;
    private String registerAddress;
    private String mainAddress;
    private String email;
    private String workContractID;
    private boolean declaration;
    private String penaltyID;

    public Member(@JsonProperty("id") UUID id, @JsonProperty("name") String name,
                  @JsonProperty("personalID") String personalID, @JsonProperty("major") String major,
                  @JsonProperty("sex") String sex, @JsonProperty("photo") String photo,
                  @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("registerDate") Date registerDate,
                  @JsonProperty("region") String region, @JsonProperty("membershipID") String membershipID,
                  @JsonProperty("registerAddress") String registerAddress, @JsonProperty("mainAddress") String mainAddress,
                  @JsonProperty("email") String email, @JsonProperty("workContractID") String workContractID,
                  @JsonProperty("declaration") boolean declaration, @JsonProperty("penaltyID") String penaltyID) {
        this.id = id;
        this.name = name;
        this.personalID = personalID;
        this.major = major;
        this.sex = sex;
        this.photo = photo;
        this.phoneNumber = phoneNumber;
        this.registerDate = registerDate;
        this.region = region;
        this.membershipID = membershipID;
        this.registerAddress = registerAddress;
        this.mainAddress = mainAddress;
        this.email = email;
        this.workContractID = workContractID;
        this.declaration = declaration;
        this.penaltyID = penaltyID;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPersonalID() {
        return personalID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSex() {
        return sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMembershipID() {
        return membershipID;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkContractID() {
        return workContractID;
    }

    public void setWorkContractID(String workContractID) {
        this.workContractID = workContractID;
    }

    public boolean isDeclaration() {
        return declaration;
    }

    public void setDeclaration(boolean declaration) {
        this.declaration = declaration;
    }

    public String getPenaltyID() {
        return penaltyID;
    }

    public void setPenaltyID(String penaltyID) {
        this.penaltyID = penaltyID;
    }
}
