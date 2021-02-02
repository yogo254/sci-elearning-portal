package com.yogo.scielearningportal.controler.auth;

import java.security.Principal;

import com.yogo.scielearningportal.domain.Users;
import com.yogo.scielearningportal.service.auth.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthControler {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/student")
    public ResponseEntity<?> addStudent(@RequestBody Users student, Principal principal) {
        return authService.registerStudent(student, principal);
    }

    @PostMapping("/register/staff")
    public ResponseEntity<?> addStaff(@RequestBody Users staff, Principal principal) {
        return authService.registerStaff(staff, principal);
    }

}
