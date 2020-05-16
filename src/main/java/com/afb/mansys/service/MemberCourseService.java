package com.afb.mansys.service;

import com.afb.mansys.dao.MemberCourseDao;
import com.afb.mansys.model.MemberCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberCourseService {

    private final MemberCourseDao memberCourseDao;

    @Autowired
    public MemberCourseService(@Qualifier("postgres") MemberCourseDao memberCourseDao) {
        this.memberCourseDao = memberCourseDao;
    }

    public List<MemberCourse> getAllMembersInCourse(int courseID){
        return memberCourseDao.getAllMembersInCourse(courseID);
    }

    public List<MemberCourse> getAllCoursesForMember(int memberID){
        return memberCourseDao.getAllCoursesForMember(memberID);
    }

    public String insertMemberCourse(MemberCourse memberCourse){
        return memberCourseDao.insertMemberCourse(memberCourse);
    }
}
