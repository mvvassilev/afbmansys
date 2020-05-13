package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotBlank;
import java.sql.Array;
import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Member {
    private final int id;

    @NotBlank
    private final String name;
    @NotBlank
    private final String personalID;

    private final String gender;
    private final Date registerDate;
    private String major;
    private String photo;
    private String phoneNumber;
    private String region;
    private String registerAddress;
    private String currentAddress;
    private String workAddress;
    private String email;
    private String workContractID;
    private String declaration;

    public Member(@JsonProperty("id") int id, @JsonProperty("name") String name,
                  @JsonProperty("personalID") String personalID, @JsonProperty("major") String major,
                  @JsonProperty("gender") String gender, @JsonProperty("photo") String photo,
                  @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("registerDate") Date registerDate,
                  @JsonProperty("region") String region, @JsonProperty("registerAddress") String registerAddress,
                  @JsonProperty("currentAddress") String currentAddress, @JsonProperty("declaration") String declaration,
                  @JsonProperty("workAddress") String workAddress, @JsonProperty("email") String email,
                  @JsonProperty("workContractID") String workContractID) {
        this.id = id;
        this.name = name;
        this.personalID = personalID;
        this.major = major;
        this.gender = gender;
        this.photo = photo;
        this.phoneNumber = phoneNumber;
        this.registerDate = registerDate;
        this.region = region;
        this.registerAddress = registerAddress;
        this.currentAddress = currentAddress;
        this.workAddress = workAddress;
        this.email = email;
        this.workContractID = workContractID;
        this.declaration = declaration;
    }

    public int getId() {
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

    public String getGender() {
        return gender;
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

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getWorkAddress() {
        return this.workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
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

    public String isDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }
}
