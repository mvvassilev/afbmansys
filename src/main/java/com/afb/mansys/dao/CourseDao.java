package com.afb.mansys.dao;

import com.afb.mansys.model.Course;

import java.util.List;

public interface CourseDao {
    String insertCourse(Course course); //TODO

    String updateCourseByID(Course course, int id); //TODO

    List<Course> getAllCoursesByMemberID(int memberID); //TODO

    List<Course> getAllCourses(); //TODO
}
