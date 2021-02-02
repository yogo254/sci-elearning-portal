package com.yogo.scielearningportal.controler.course;

import java.util.List;

import com.yogo.scielearningportal.domain.Course;
import com.yogo.scielearningportal.service.course.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseControler {

    @Autowired
    private CourseService courseService;

    @PostMapping

    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping("/id/{id}")

    public Course findById(@PathVariable("id") String id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/department/{department}")
    public List<Course> findAllByDepartment(@PathVariable("department") String department) {
        return courseService.getAllByDepartment(department);

    }

    @GetMapping("/school/{school}")
    public List<Course> findAllBySchool(@PathVariable("school") String school) {
        return courseService.getAllByDepartment(school);

    }

}
