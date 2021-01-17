package com.yogo.scielearningportal.repo;

import java.util.List;

import com.yogo.scielearningportal.domain.UserRoles;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRolesRepo extends MongoRepository<UserRoles, String> {

    List<UserRoles> findAllByUserId(String userId);

}
