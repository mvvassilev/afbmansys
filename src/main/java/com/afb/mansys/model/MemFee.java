package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemFee {
    private int id;
    private String type;
    private String year;
    private int memberID;

    public MemFee(@JsonProperty("id") int id, @JsonProperty("type") String type,
                  @JsonProperty("year") String year, @JsonProperty("memberID") int memberID) {
        this.id = id;
        this.type = type;
        this.year = year;
        this.memberID = memberID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
