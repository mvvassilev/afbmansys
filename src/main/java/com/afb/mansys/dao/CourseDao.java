package com.afb.mansys.dao;

import com.afb.mansys.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseDao {
    String insertCourse(Course course);

    String updateCourseByID(Course course, int id);

    List<Course> getAllCoursesByMemberID(int memberID); //TODO

    List<Course> getAllCourses();

    Optional<Course> getCourseByID(int id);

    String deleteCourseByID(int id);
}
