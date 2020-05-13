package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddQualification {
    private String id;
    private String degree;
    private String university;
    private String major;
    private String duration;
    private int memberID;

    public AddQualification(@JsonProperty("id") String id, @JsonProperty("degree") String degree,
                            @JsonProperty("university") String university, @JsonProperty("major") String major,
                            @JsonProperty("duration") String duration, @JsonProperty("memberID") int memberID) {
        this.id = id;
        this.degree = degree;
        this.university = university;
        this.major = major;
        this.duration = duration;
        this.memberID = memberID;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
