package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.List;

public interface UserService  {

    List<User> getAllUsers();

    List<Role> getAllRoles();

    void saveUser(User user);

    User getUser(Long id);

    void updateUser(User updateUser);

    void deleteUser(Long id);

    User getByEmail(String email);

}
