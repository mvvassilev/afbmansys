package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Course {
    private final int id;
    private String courseName;
    private String language;
    private Date date;
    private String validityPeriod;

    public Course(@JsonProperty int id, @JsonProperty String courseName, @JsonProperty String language,
                  @JsonProperty Date date, @JsonProperty String validityPeriod) {
        this.id = id;
        this.courseName = courseName;
        this.language = language;
        this.date = date;
        this.validityPeriod = validityPeriod;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }
}
