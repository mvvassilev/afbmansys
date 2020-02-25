package com.afb.mansys.model;

import java.util.Date;
import java.util.UUID;

public class Course {
    private final UUID id;
    private String courseName;
    private String language;
    private Date date;
    private String validityPeriod;

    public Course(UUID id, String courseName, String language, Date date, String validityPeriod) {
        this.id = id;
        this.courseName = courseName;
        this.language = language;
        this.date = date;
        this.validityPeriod = validityPeriod;
    }

    public UUID getId() {
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
