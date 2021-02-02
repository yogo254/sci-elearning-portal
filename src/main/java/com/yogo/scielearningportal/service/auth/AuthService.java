package com.yogo.scielearningportal.service.auth;

import java.security.Principal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import com.yogo.scielearningportal.domain.AccountType;
import com.yogo.scielearningportal.domain.UserRoles;
import com.yogo.scielearningportal.domain.Users;
import com.yogo.scielearningportal.repo.UserRolesRepo;
import com.yogo.scielearningportal.repo.UsersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private UserRolesRepo userRolesRepo;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public ResponseEntity<?> registerStaff(Users staff, Principal principal) {
        Optional<String> email = Optional.ofNullable(staff.getEmail());

        if (email.isPresent()) {
            Optional<Users> st = usersRepo.findOneByEmail(staff.getEmail());
            if (st.isPresent()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(updateStaff(staff, principal));

            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(insertStaff(staff, principal));
            }

        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email address is required");

    }

    public ResponseEntity<?> registerStudent(Users student, Principal principal) {
        Optional<String> email = Optional.ofNullable(student.getEmail());

        if (email.isPresent()) {
            Optional<Users> st = usersRepo.findOneByEmail(student.getEmail());
            if (st.isPresent()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(updateStudent(student));

            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(insertStudent(student, principal));
            }

        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email address is required");

    }

    private Users insertStudent(Users student, Principal principal) {
        student.setAccountType(AccountType.STUDENT);
        student.setTimestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        student.setPassword(encoder.encode(student.getPassword()));
        student = usersRepo.save(student);

        UserRoles role = new UserRoles();
        role.setUserId(student.getId());
        role.setRole("ROLE_STUDENT");
        role.setAssignedBy(principal.getName());
        role.setTimestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        userRolesRepo.save(role);
        return student;

    }

    private Users updateStudent(Users student) {
        student.setAccountType(AccountType.STUDENT);
        student.setTimestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        student = usersRepo.save(student);

        return student;

    }

    private Users insertStaff(Users staff, Principal principal) {
        staff.setTimestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        staff.setPassword(encoder.encode(staff.getPassword()));
        staff = usersRepo.save(staff);

        for (String r : staff.getRoles()) {
            UserRoles role = new UserRoles();
            role.setUserId(staff.getId());
            role.setRole(r);
            role.setAssignedBy(principal.getName());
            role.setTimestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
            userRolesRepo.save(role);

        }

        return staff;

    }

    private Users updateStaff(Users staff, Principal principal) {
        staff.setTimestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        staff = usersRepo.save(staff);

        for (String r : staff.getRoles()) {
            UserRoles role = new UserRoles();
            role.setUserId(staff.getId());
            role.setRole(r);
            role.setAssignedBy(principal.getName());
            role.setTimestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
            userRolesRepo.save(role);

        }

        return staff;

    }

}
