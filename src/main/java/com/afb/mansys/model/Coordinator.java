package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinator {
    private String username;
    private final int memberID;
    private String password;
    private String region;

    public Coordinator(@JsonProperty("username") String username, @JsonProperty("memberID") int memberID,
                       @JsonProperty("password") String password, @JsonProperty("region") String region) {
        this.username = username;
        this.memberID = memberID;
        this.password = password;
        this.region = region;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
