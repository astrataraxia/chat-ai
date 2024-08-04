package com.example.tinderaibackend;

import com.example.tinderaibackend.profiles.properties.UserProfileProperties;
import com.example.tinderaibackend.profiles.service.ProfileCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(UserProfileProperties.class)
public class TinderAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ProfileCreationService profileCreationService;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		profileCreationService.createProfiles(0);
		profileCreationService.saveProfilesToDB();
	}
}
