package com.yogo.scielearningportal.security;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.yogo.scielearningportal.domain.Users;
import com.yogo.scielearningportal.repo.UserRolesRepo;
import com.yogo.scielearningportal.repo.UsersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepo userRepository;
    @Autowired
    private UserRolesRepo roleRepo;

    public UserDetailsServiceImpl() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> user = userRepository.findOneByEmail(username);
        if (user.isPresent()) {
            List<SimpleGrantedAuthority> grantedAuthorities = roleRepo.findAllByUserId(user.get().getId()).stream()
                    .map(r -> r.getRole()).map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());

            return new User(user.get().getEmail(), user.get().getPassword(), grantedAuthorities);

        } else {
            System.out.println("[username => " + username + "]" + " NO USER FOUND!!!!");
            throw new UsernameNotFoundException("Invalid user");
        }

    }

}
