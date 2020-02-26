package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Coordinator {
    private final UUID id;
    private String username;
    private String password;
    private String region;

    public Coordinator(@JsonProperty UUID id, @JsonProperty String username,
                       @JsonProperty String password, String region) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.region = region;
    }

    public UUID getId() {
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
