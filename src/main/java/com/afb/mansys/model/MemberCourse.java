package com.afb.mansys.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberCourse {
    private int memberID;
    private int courseID;

    public MemberCourse(@JsonProperty("memberID") int memberID, @JsonProperty("courseID") int courseID) {
        this.memberID = memberID;
        this.courseID = courseID;
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
