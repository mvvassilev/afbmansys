package com.afb.mansys.api;

import com.afb.mansys.model.MemberCourse;
import com.afb.mansys.service.MemberCourseService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@JsonSerialize
@CrossOrigin("http://localhost:4200")
@RequestMapping("membercourses")
@RestController
public class MemberCourseController {

    private final MemberCourseService memberCourseService;

    @Autowired
    public MemberCourseController(MemberCourseService memberCourseService) {
        this.memberCourseService = memberCourseService;
    }

    @GetMapping(path = "courseID/{courseID}")
    public Optional<List<MemberCourse>> getAllMembersInCourse(@PathVariable("courseID") int courseID) {
        return memberCourseService.getAllMembersInCourse(courseID);
    }

    @GetMapping(path = "memberID/{memberID}")
    public Optional<List<MemberCourse>> getAllCoursesForMember(@PathVariable("memberID") int memberID) {
        return memberCourseService.getAllCoursesForMember(memberID);
    }

    @PostMapping(path = "new")
    public String insertMemberCourse(@Valid @NotNull @RequestBody MemberCourse memberCourse) {
        return memberCourseService.insertMemberCourse(memberCourse);
    }
}
