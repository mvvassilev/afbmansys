package com.afb.mansys.service;

import com.afb.mansys.dao.CourseDao;
import com.afb.mansys.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseService(@Qualifier("postgres") CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public String insertCourse(Course course) {
        return courseDao.insertCourse(course);
    }

    public String updateCourseByID(Course course, int id) {
        return courseDao.updateCourseByID(course, id);
    }

    public List<Course> getAllCoursesByMemberID(int memberID) {
        return courseDao.getAllCoursesByMemberID(memberID);
    }

    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    public Optional<Course> getCourseByID(int id) {
        return courseDao.getCourseByID(id);
    }

    public String deleteCourseByID(int id){
        return courseDao.deleteCourseByID(id);
    }
}
