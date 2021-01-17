package com.yogo.scielearningportal.repo;

import java.util.Optional;

import com.yogo.scielearningportal.domain.Users;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepo extends MongoRepository<Users, String> {
    Optional<Users> findOneByEmail(String email);

}
