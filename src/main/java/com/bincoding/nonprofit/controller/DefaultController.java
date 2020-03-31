package com.bincoding.nonprofit.controller;

import com.bincoding.nonprofit.entity.HelloWorld;
import com.bincoding.nonprofit.entity.UserEntity;
import com.bincoding.nonprofit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class DefaultController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = {"/", "/index"})
    public HelloWorld getWelcome() {
        return new HelloWorld("Welcome to the Non-Profit SpringBoot Project!");
    }

   @GetMapping(value = "/message")
   public HelloWorld getMessage() {
        return new HelloWorld("Hello World");
    }


    @PostMapping("/createUser")
    public String create(@RequestBody UserEntity user){
    // save a single UserEntity
        userRepository.save(new UserEntity(user.getFname(), user.getLname()));
        return "UserEntity is created";
    }

}
