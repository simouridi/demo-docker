package com.minty.demodocker.service;

import com.minty.demodocker.entities.Role;
import com.minty.demodocker.entities.User;
import com.minty.demodocker.repository.RoleRepository;
import com.minty.demodocker.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }


    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }


    @Override
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }


    @Override
    public void addRoleTouser(String email, String roleName) {
        User user = userRepository.findByEmail(email).get();
        Role role = roleRepository.findByRoleName(roleName).get();
        user.getRoleList().add(role);
    }
}
