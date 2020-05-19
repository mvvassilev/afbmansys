package com.afb.mansys.service;

import com.afb.mansys.dao.MemberCourseDao;
import com.afb.mansys.model.MemberCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberCourseService {

    private final MemberCourseDao memberCourseDao;

    @Autowired
    public MemberCourseService(@Qualifier("postgres") MemberCourseDao memberCourseDao) {
        this.memberCourseDao = memberCourseDao;
    }

    public Optional<List<MemberCourse>> getAllMembersInCourse(int courseID){
        return memberCourseDao.getAllMembersInCourse(courseID);
    }

    public Optional<List<MemberCourse>> getAllCoursesForMember(int memberID){
        return memberCourseDao.getAllCoursesForMember(memberID);
    }

    public String insertMemberCourse(MemberCourse memberCourse){
        return memberCourseDao.insertMemberCourse(memberCourse);
    }
}
