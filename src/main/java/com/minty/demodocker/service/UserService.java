package com.minty.demodocker.service;

import com.minty.demodocker.entities.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    User getUser(Long id);
    User getUserByEmail(String email);
    User updateUser(User user);
    void deleteUser(Long id);
    List<User> getUserList();
    void addRoleTouser(String email, String roleName);
}
