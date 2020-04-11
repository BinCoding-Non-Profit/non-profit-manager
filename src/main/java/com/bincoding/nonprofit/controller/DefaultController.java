package com.bincoding.nonprofit.controller;

import com.bincoding.nonprofit.entity.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DefaultController {

    @GetMapping(value = {"/", "/index"})
    public HelloWorld getWelcome() {
        return new HelloWorld("Welcome to the Non-Profit SpringBoot Project!");
    }

   @GetMapping(value = "/message")
   public HelloWorld getMessage() {
        return new HelloWorld("Hello World");
    }

}
