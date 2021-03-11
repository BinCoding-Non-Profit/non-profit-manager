package com.bincoding.nonprofit.controller;

import com.bincoding.nonprofit.dto.UserWithoutPass;
import com.bincoding.nonprofit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<UserWithoutPass> getUserById(@PathVariable("id") int userId) {
        Optional<UserWithoutPass> user = userService.findWithoutPassById(userId);
        return user.map(u -> ResponseEntity.ok().body(u)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/user")
    public ResponseEntity<UserWithoutPass> getUserByUsername(@RequestParam("username") String username) {
        Optional<UserWithoutPass> user = userService.findWithoutPassByUsername(username);
        return user.map(u -> ResponseEntity.ok().body(u)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/users")
    public List<UserWithoutPass> getAllUsers() {
        return userService.findAllWithoutPass();
    }
}
