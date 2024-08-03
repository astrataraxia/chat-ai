package com.example.tinderaibackend.conversations.service;

import com.example.tinderaibackend.conversations.dto.CreateConversationRequest;
import com.example.tinderaibackend.conversations.dto.CreateConversationResponse;
import com.example.tinderaibackend.conversations.entity.Conversation;
import com.example.tinderaibackend.conversations.repository.ConversationRepository;
import com.example.tinderaibackend.profiles.repository.ProfileRepository;
import com.soundicly.jnanoidenhanced.jnanoid.NanoIdUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final ProfileRepository profileRepository;

    public CreateConversationResponse newConversation(CreateConversationRequest request) {
        profileRepository.findById(request.profileId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found"));

        Conversation conversation = new Conversation(
                NanoIdUtils.randomNanoId(),
                request.profileId(),
                new ArrayList<>()
        );

        return CreateConversationResponse.from(conversationRepository.save(conversation));
    }
}
