package com.afb.mansys.dao;

import com.afb.mansys.model.Course;

import java.util.List;

public interface CourseDao {
    String insertCourse(Course course);

    String updateCourseByID(Course course, int id);

    List<Course> getAllCoursesByMemberID(int memberID);

    List<Course> getAllCourses();
}
