package com.examplejwt.authenticationproject.controllers;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping("/hello")
    public String helloAdmin(JwtAuthenticationToken token) {
        return "Hello, admin "+token.getName()+"!";
    }
}
