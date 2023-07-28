package com.examplejwt.authenticationproject.controllers;

import com.examplejwt.authenticationproject.user.UserService;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main")
public record MainController(UserService userService) {

    @GetMapping("/greeting")
    public String greeting(JwtAuthenticationToken authenticationToken) {
        return "Hello, "+authenticationToken.getName()+"! "+"Your ID is: "+authenticationToken.getToken().getId()+"!";
    }
}
