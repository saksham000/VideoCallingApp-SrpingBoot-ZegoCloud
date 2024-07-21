package com.videocall.videocallingproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.videocall.videocallingproject.user.User;
import com.videocall.videocallingproject.user.UserService;

@SpringBootApplication
public class VideocallingprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallingprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunnerr(UserService service) {
		return args -> {
					service.register(User.builder()
					.username("saksham")
					.email("saksham@mail.com")
					.password("sss")
					.build());
		};
	}

}
