package com.yogo.scielearningportal.repo;

import com.yogo.scielearningportal.domain.Question;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepo extends MongoRepository<Question, String> {

}
