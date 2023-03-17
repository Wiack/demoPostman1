package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;

public interface RoleService {

    Role findByName(String name);

    List<Role> findAll();

    void saveRole(Role role);

}
