package com.examplejwt.authenticationproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("main")
public class MainController {
    @GetMapping("/greeting")
    public String greeting(Principal principal) {
        return "Hello, "+principal.getName()+"!";
    }
}
