package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Course {
    private final int id;
    private String name;
    private Date date;
    private String lector;

    public Course(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("date") Date date,
                  @JsonProperty("lector") String lector) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.lector = lector;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
        this.lector = lector;
    }
}
