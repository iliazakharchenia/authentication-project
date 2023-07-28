package com.examplejwt.authenticationproject.service;

import com.examplejwt.authenticationproject.user.UserEntity;
import com.examplejwt.authenticationproject.user.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class TokenService {

    private final JwtEncoder jwtEncoder;

    private final UserRepository userRepository;

    public TokenService(JwtEncoder jwtEncoder, UserRepository userRepository) {
        this.jwtEncoder = jwtEncoder;
        this.userRepository = userRepository;
    }

    public String generateToken(Authentication authentication) {
        // check if user exists
        Optional<UserEntity> optionalUser = userRepository.findUserEntityByName(authentication.getName());
        if (optionalUser.isEmpty()) throw new RuntimeException(
                "user with name: " + authentication.getName()
                        + " -- not found");

        // creating a token
        Instant now = Instant.now();

        // token with authority, name and id
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(3, ChronoUnit.MINUTES))
                .subject(authentication.getName())
                .id(optionalUser.get().getId().toString())
                .claim("scope", optionalUser.get().getAuthority())
                .build();
        return this.jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
    }

}
