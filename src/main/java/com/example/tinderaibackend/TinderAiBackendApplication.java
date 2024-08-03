package com.example.tinderaibackend;

import com.example.tinderaibackend.conversations.entity.ChatMessage;
import com.example.tinderaibackend.conversations.entity.Conversation;
import com.example.tinderaibackend.conversations.repository.ConversationRepository;
import com.example.tinderaibackend.profiles.entitiy.enums.Gender;
import com.example.tinderaibackend.profiles.entitiy.Profile;
import com.example.tinderaibackend.profiles.repository.ProfileRepository;
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

		profileRepository.deleteAll();
		conversationRepository.deleteAll();

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
		profile = new Profile(
				"2",
				"kim",
				"seungyong",
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
