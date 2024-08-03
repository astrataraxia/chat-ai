package com.example.tinderaibackend.conversations.controller;

import com.example.tinderaibackend.conversations.dto.CreateConversationRequest;
import com.example.tinderaibackend.conversations.dto.CreateConversationResponse;
import com.example.tinderaibackend.conversations.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

    @PostMapping("/conversations")
    public CreateConversationResponse createNewConversation(@RequestBody CreateConversationRequest request) {
        return conversationService.newConversation(request);
    }

}
