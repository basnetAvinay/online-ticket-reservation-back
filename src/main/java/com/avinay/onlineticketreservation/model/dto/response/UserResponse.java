package com.avinay.onlineticketreservation.model.dto.response;

import com.avinay.onlineticketreservation.model.entity.Role;
import com.avinay.onlineticketreservation.model.entity.User;

import java.util.Set;

public class UserResponse extends User {
    private User user;

    public UserResponse(User user) {
        this.user = user;
    }

    @Override
    public Integer getUserId() {
        return user.getUserId();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getFirstName() {
        return user.getFirstName();
    }

    @Override
    public String getLastName() {
        return user.getLastName();
    }

    @Override
    public boolean isActive() {
        return user.isActive();
    }

    @Override
    public Set<Role> getRoles() {
        return user.getRoles();
    }
}
