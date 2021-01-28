package com.yogo.scielearningportal.repo;

import com.yogo.scielearningportal.domain.Transcript;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TranscriptRepo extends MongoRepository<Transcript, String> {

}
