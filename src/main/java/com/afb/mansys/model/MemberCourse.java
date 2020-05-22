package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberCourse {
    private final int id;
    private int memberID;
    private int courseID;

    public MemberCourse(@JsonProperty("id") int id, @JsonProperty("memberID") int memberID,
                        @JsonProperty("courseID") int courseID) {
        this.id = id;
        this.memberID = memberID;
        this.courseID = courseID;
    }

    public int getId() {
        return id;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
