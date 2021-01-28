package com.yogo.scielearningportal.repo;

import com.yogo.scielearningportal.domain.UnitResource;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UnitResourceRepo extends MongoRepository<UnitResource, String> {

}
