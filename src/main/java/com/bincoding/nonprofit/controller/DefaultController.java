package com.bincoding.nonprofit.controller;

import com.bincoding.nonprofit.entity.HelloWorld;
import com.bincoding.nonprofit.entity.UserEntity;
import com.bincoding.nonprofit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DefaultController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/")
    public HelloWorld getWelcome() {
        return new HelloWorld("Welcome to the Non-Profit SpringBoot Project!");
    }

   @GetMapping(value = "/message")
   public HelloWorld getMessage() {
        return new HelloWorld("Hello World");
    }

    @GetMapping(value = "/user")
    public String user(Authentication authentication){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<UserEntity> userEntity = userRepository.findByUsername(userDetails.getUsername());
        return "<h1>Welcome " + userEntity.get().getFname() + " " + userEntity.get().getLname()  +  "</h1>";
//        return "<h1>Welcome  User</h1>";
    }

    @GetMapping(value = "/admin")
    public String admin(){
        return "<h1>Welcome Admin</h1>";
    }


    @PostMapping("/createUser")
    public String create(@RequestBody UserEntity user){
    // save a single UserEntity
        userRepository.save(user);
        return "UserEntity is created";
    }

}
