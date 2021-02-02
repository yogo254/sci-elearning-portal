package com.yogo.scielearningportal.service.user;

import java.util.List;
import java.util.Optional;

import com.yogo.scielearningportal.domain.Users;
import com.yogo.scielearningportal.repo.UsersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired

    private UsersRepo usersRepo;

    public List<Users> getUsersByCourseId(String courseId) {
        return usersRepo.findAllByCourseId(courseId);
    }

    public List<Users> getAllUsers() {
        return usersRepo.findAll(Sort.by("timestamp").descending());

    }

    public Users getById(String id) {
        Optional<Users> user = usersRepo.findById(id);
        if (user.isPresent())
            return user.get();
        else
            return null;
    }

    public Users getByRegNo(String regNo) {
        Optional<Users> user = usersRepo.findOneByRegNo(regNo);
        if (user.isPresent())
            return user.get();
        else
            return null;
    }

}
