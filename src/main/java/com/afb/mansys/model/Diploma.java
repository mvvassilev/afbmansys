package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Diploma {
    private String id;
    private String degree;
    private String university;
    private String major;
    private String startDate;
    private String endDate;

    public Diploma(@JsonProperty("id") String id, @JsonProperty("degree") String degree,
                   @JsonProperty("university") String university, @JsonProperty("major") String major,
                   @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate) {
        this.id = id;
        this.degree = degree;
        this.university = university;
        this.major = major;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
