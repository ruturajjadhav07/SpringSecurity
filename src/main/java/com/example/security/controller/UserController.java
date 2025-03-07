package com.example.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.model.Users;
import com.example.security.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/register")
    public Users register (@RequestBody Users user){
        return userService.register(user.getUsername(),user.getPassword());
    }

    @PostMapping("/login")
    public String addUser(@RequestBody Users user) {
        System.out.println(user);
        return userService.verify(user);
    }


    @GetMapping
    public String getSession(HttpServletRequest httpServletRequest) {
        return "Session Id: " + httpServletRequest.getSession().getId();
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest httpServletRequest) {
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

}
