package com.examplejwt.authenticationproject.controllers;

import com.examplejwt.authenticationproject.user.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reg")
public record RegistrationController(UserRepository userRepository) {
}
