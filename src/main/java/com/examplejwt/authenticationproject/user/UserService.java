package com.examplejwt.authenticationproject.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity addUser(UserDtoRequest userDto) {
        return userRepository.save(new UserEntity(
                null,
                userDto.name(),
                userDto.password(),
                userDto.authority()
        ));
    }

    public boolean isUserWithUsernameExists(String name) {
        return userRepository.findUserEntityByName(name).isPresent();
    }

    public UserEntity loadUserByUsername(String name) {
        Optional<UserEntity> optionalUser = userRepository.findUserEntityByName(name);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException("user with name: "+name+" -- not found");
        }
    }
}
