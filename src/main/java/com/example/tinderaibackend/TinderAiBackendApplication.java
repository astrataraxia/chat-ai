package com.example.tinderaibackend;

import com.example.tinderaibackend.profiles.Gender;
import com.example.tinderaibackend.profiles.Profile;
import com.example.tinderaibackend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Profile profile = new Profile(
				"1",
				"Kousic",
				"Kourth",
				33,
				"Korean",
				Gender.MALE,
				"Software Programmer",
				"foo.jpg",
				"ISTJ"
		);
		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);
	}
}
