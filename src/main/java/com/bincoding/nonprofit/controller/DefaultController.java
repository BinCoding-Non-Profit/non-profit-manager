package com.bincoding.nonprofit.controller;

import com.bincoding.nonprofit.entity.HelloWorld;
import com.bincoding.nonprofit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DefaultController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/")
    public HelloWorld getWelcome() {
        return new HelloWorld("Hello BinCoding!");
    }
}
