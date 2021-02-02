package com.yogo.scielearningportal.service.course;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.yogo.scielearningportal.domain.Course;
import com.yogo.scielearningportal.repo.CourseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public Course addCourse(Course course) {
        course.setTimestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        return courseRepo.save(course);

    }

    public List<Course> getAllByDepartment(String department) {
        return courseRepo.findAllByDepartment(department, Sort.by("timestamp").descending());
    }

    public List<Course> getAllBySchool(String school) {
        return courseRepo.findAllBySchool(school, Sort.by("timestamp").descending());
    }

    public Course getCourseById(String id) {
        Optional<Course> course = courseRepo.findById(id);
        if (course.isPresent())
            return course.get();
        else
            return null;

    }

}
