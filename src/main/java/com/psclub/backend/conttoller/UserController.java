package com.psclub.backend.controller;

import com.psclub.backend.model.User;
import com.psclub.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Регистрация пользователя (POST)
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registered = userService.registerUser(user);
        return ResponseEntity.ok(registered);
    }

    // Получить всех пользователей (GET)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
