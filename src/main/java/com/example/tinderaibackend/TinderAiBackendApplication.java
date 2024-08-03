package com.example.tinderaibackend;

import com.example.tinderaibackend.conversations.entity.ChatMessage;
import com.example.tinderaibackend.conversations.entity.Conversation;
import com.example.tinderaibackend.conversations.repository.ConversationRepository;
import com.example.tinderaibackend.profiles.Gender;
import com.example.tinderaibackend.profiles.Profile;
import com.example.tinderaibackend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ConversationRepository conversationRepository;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}

	@Override
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

		Conversation conversation = new Conversation(
				"1",
				profile.id(),
				List.of(new ChatMessage("Hello", profile.id(), LocalDateTime.now())));

		conversationRepository.save(conversation);
		conversationRepository.findAll().forEach(System.out::println);
	}
}
