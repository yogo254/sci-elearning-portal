package com.yogo.scielearningportal.controler.user;

import java.util.List;

import com.yogo.scielearningportal.domain.Users;
import com.yogo.scielearningportal.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentControler {
    @Autowired
    private UserService userService;

    @GetMapping("/course/{id}")
    public List<Users> getStudentsByCourse(@PathVariable("id") String id) {
        return userService.getUsersByCourseId(id);

    }

    @GetMapping

    public List<Users> getAllStudents() {
        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public Users getUserById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    @GetMapping("/regNo/{regNo}")
    public Users getStudentByRegNo(@PathVariable("regNo") String regNo) {
        return userService.getByRegNo(regNo);
    }

}
