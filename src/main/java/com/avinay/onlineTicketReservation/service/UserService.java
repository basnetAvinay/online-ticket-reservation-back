package com.avinay.onlineTicketReservation.service;

import com.avinay.onlineTicketReservation.model.Role;
import com.avinay.onlineTicketReservation.model.User;
import com.avinay.onlineTicketReservation.repository.RoleRepository;
import com.avinay.onlineTicketReservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        return userRepository.save(user);
    }


}