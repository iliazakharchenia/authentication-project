package com.examplejwt.authenticationproject.user;

public record UserDtoRequest (String name, String password, UserAuthority authority) {
}
