package com.example.tinderaibackend.conversations.dto;

import com.example.tinderaibackend.conversations.entity.ChatMessage;
import com.example.tinderaibackend.conversations.entity.Conversation;

import java.util.List;

public record CreateConversationResponse(
        String id,
        String profileId,
        List<ChatMessage> messages
) {

    public static CreateConversationResponse from(Conversation conversation) {
        return new CreateConversationResponse(conversation.id(), conversation.profileId(), conversation.messages());
    }
}
