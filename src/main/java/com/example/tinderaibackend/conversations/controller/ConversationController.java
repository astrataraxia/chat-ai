package com.example.tinderaibackend.conversations.controller;

import com.example.tinderaibackend.conversations.dto.ConversationResponse;
import com.example.tinderaibackend.conversations.dto.CreateConversationRequest;
import com.example.tinderaibackend.conversations.entity.ChatMessage;
import com.example.tinderaibackend.conversations.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

    @PostMapping("/conversations")
    @ResponseStatus(HttpStatus.CREATED)
    public ConversationResponse createNewConversation(@RequestBody CreateConversationRequest request) {
        return conversationService.newConversation(request);
    }

    @PostMapping("/conversations/{conversationId}")
    @ResponseStatus(HttpStatus.OK)
    public ConversationResponse addMessage(
            @PathVariable("conversationId") String conversationId,
            @RequestBody ChatMessage message) {
        return conversationService.addMessageToConversation(conversationId, message);
    }

}
