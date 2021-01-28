package com.yogo.scielearningportal.repo;

import com.yogo.scielearningportal.domain.Semester;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SemesterRepo extends MongoRepository<Semester, String> {

}
