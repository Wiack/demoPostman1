package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User showUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/save")
    public User addUser(@RequestBody User user) {
        userService.saveUser(user);

        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User udalen";
    }

    @PatchMapping("/{id}")
    public User updateUser(@RequestBody User user) {
        //User user = userService.getUser(id);
        userService.updateUser(user);
        return user;
    }
}
