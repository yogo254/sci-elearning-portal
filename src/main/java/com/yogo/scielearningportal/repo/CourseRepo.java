package com.yogo.scielearningportal.repo;

import com.yogo.scielearningportal.domain.Course;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepo extends MongoRepository<Course, String> {

}
