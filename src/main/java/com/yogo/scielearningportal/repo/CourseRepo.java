package com.yogo.scielearningportal.repo;

import java.util.List;

import com.yogo.scielearningportal.domain.Course;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepo extends MongoRepository<Course, String> {
    List<Course> findAllByDepartment(String department, Sort sort);

    List<Course> findAllBySchool(String school, Sort sort);

}
