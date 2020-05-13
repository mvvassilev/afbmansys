package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class Penalty {
    private int id;
    private Date startDate;
    private String name;
    private String isCancelled;
    private int memberID;

    public Penalty(@JsonProperty("id") int id, @JsonProperty("startDate") Date startDate,
                   @JsonProperty("name") String name, @JsonProperty("isCancelled") String isCancelled,
                   @JsonProperty("memberID") int memberID) {
        this.id = id;
        this.startDate = startDate;
        this.name = name;
        this.isCancelled = isCancelled;
        this.memberID = memberID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(String isCancelled) {
        this.isCancelled = isCancelled;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
