package com.afb.mansys.api;

import com.afb.mansys.model.Course;
import com.afb.mansys.service.CourseService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@JsonSerialize
@CrossOrigin("http://localhost:4200")
@RequestMapping("courses")
@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(path = "new")
    public String insertCourse(@Valid @NotNull @RequestBody Course course){
        return courseService.insertCourse(course);
    }

    @PutMapping(path = "{id}")
    public String updateCourseByID(@Valid @NotNull @RequestBody Course course, @PathVariable("id") int id){
        return courseService.updateCourseByID(course, id);
    }

    @GetMapping(path = "memberID/{id}")
    public List<Course> getAllCoursesByMemberID(int memberID){
        return courseService.getAllCoursesByMemberID(memberID);
    }

    @GetMapping(path = "all")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping(path = "{id}")
    public Optional<Course> getCourseByID(@PathVariable("id") int id){
        return courseService.getCourseByID(id);
    }

    @DeleteMapping(path = "{id}")
    public String deleteCourseByID(@PathVariable("id") int id) {
        return courseService.deleteCourseByID(id);
    }
}
