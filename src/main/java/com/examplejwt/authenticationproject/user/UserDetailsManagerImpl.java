package com.examplejwt.authenticationproject.user;

import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public record UserDetailsManagerImpl(@Getter UserService userService) implements org.springframework.security.provisioning.UserDetailsManager {
    @Override
    public void createUser(UserDetails user) {
    }

    @Override
    public void updateUser(UserDetails user) {
    }

    @Override
    public void deleteUser(String username) {
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
    }

    @Override
    public boolean userExists(String username) {
        return userService.isUserWithUsernameExists(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.loadUserByUsername(username);
        System.out.println(user.toString()); // for test

        return new UserDetailsImpl(user.getName(), user.getPassword(), user.getAuthority());
    }
}
