package com.example.tinderaibackend.conversations.service;

import com.example.tinderaibackend.conversations.dto.CreateConversationRequest;
import com.example.tinderaibackend.conversations.dto.ConversationResponse;
import com.example.tinderaibackend.conversations.entity.ChatMessage;
import com.example.tinderaibackend.conversations.entity.Conversation;
import com.example.tinderaibackend.conversations.repository.ConversationRepository;
import com.example.tinderaibackend.profiles.entitiy.Profile;
import com.example.tinderaibackend.profiles.repository.ProfileRepository;
import com.soundicly.jnanoidenhanced.jnanoid.NanoIdUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final ProfileRepository profileRepository;

    public ConversationResponse newConversation(CreateConversationRequest request) {
        validateProfile(request.profileId());

        Conversation conversation = new Conversation(
                NanoIdUtils.randomNanoId(),
                request.profileId(),
                new ArrayList<>()
        );

        return ConversationResponse.from(conversationRepository.save(conversation));
    }

    public ConversationResponse addMessageToConversation(String conversationId, ChatMessage chatMessage) {

        Conversation conversation = validateConversation(conversationId);
        validateProfile(chatMessage.authorId());
        //TODO: Need to validate that the author of a message happen to be only the profile associated with the message user

        ChatMessage messageWithTime = new ChatMessage(
                chatMessage.messageText(),
                chatMessage.authorId(),
                LocalDateTime.now());

        conversation.messages().add(messageWithTime);
        return ConversationResponse.from(conversationRepository.save(conversation));
    }

    private Conversation validateConversation(String conversationId) {
        return conversationRepository.findById(conversationId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Unable to find conversation with ID" + conversationId));
    }

    private Profile validateProfile(String request) {
        return profileRepository.findById(request)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Unable to find profile with ID" + request));
    }
}
