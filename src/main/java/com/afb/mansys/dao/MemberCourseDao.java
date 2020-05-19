package com.afb.mansys.dao;

import com.afb.mansys.model.Member;
import com.afb.mansys.model.MemberCourse;

import java.util.List;
import java.util.Optional;

public interface MemberCourseDao {

    Optional<List<MemberCourse>> getAllMembersInCourse(int courseID);

    Optional<List<MemberCourse>> getAllCoursesForMember(int memberID);

    String insertMemberCourse(MemberCourse memberCourse);
}
