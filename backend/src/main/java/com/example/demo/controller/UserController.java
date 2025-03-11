package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("http://localhost:5173")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public Users addUsers(@RequestBody Users user) {
        return userService.addUser(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public String verifyLogin(@RequestBody Users user) {
        return userService.verify(user);
    }

}
