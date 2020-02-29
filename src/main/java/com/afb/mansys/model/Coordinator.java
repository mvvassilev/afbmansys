package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinator {
    private final int id;
    private String username;
    private String password;
    private String region;

    public Coordinator(@JsonProperty int id, @JsonProperty String username,
                       @JsonProperty String password, String region) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.region = region;
    }

    public int getId() {
        return id;
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
