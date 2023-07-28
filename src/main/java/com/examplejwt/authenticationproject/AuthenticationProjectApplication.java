package com.examplejwt.authenticationproject;

import com.examplejwt.authenticationproject.config.RsaKeyProperties;
import com.examplejwt.authenticationproject.user.UserAuthority;
import com.examplejwt.authenticationproject.user.UserDtoRequest;
import com.examplejwt.authenticationproject.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class AuthenticationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationProjectApplication.class, args);
	}

	// STRICTLY for tests!!!
	@Bean
	public CommandLineRunner demoData(UserService userService) {
		return args -> {
			System.out.println(userService.addUser(
					new UserDtoRequest("user", "password", UserAuthority.USER)));
			System.out.println(userService.addUser(
					new UserDtoRequest("user1", "password1", UserAuthority.ADMIN)));
			System.out.println(userService.addUser(
					new UserDtoRequest("user2", "password2", UserAuthority.USER)));
		};
	}

}
