package com.examplejwt.authenticationproject;

import com.examplejwt.authenticationproject.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class AuthenticationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationProjectApplication.class, args);
	}

}
