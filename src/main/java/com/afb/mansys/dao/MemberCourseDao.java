package com.afb.mansys.dao;

import com.afb.mansys.model.Member;
import com.afb.mansys.model.MemberCourse;

import java.util.List;

public interface MemberCourseDao {

    List<MemberCourse> getAllMembersInCourse(int courseID);

    List<MemberCourse> getAllCoursesForMember(int memberID);
}
