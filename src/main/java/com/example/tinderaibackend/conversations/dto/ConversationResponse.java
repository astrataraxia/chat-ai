package com.example.tinderaibackend.conversations.dto;

import com.example.tinderaibackend.conversations.entity.ChatMessage;
import com.example.tinderaibackend.conversations.entity.Conversation;

import java.util.List;

public record ConversationResponse(
        String id,
        String profileId,
        List<ChatMessage> messages
) {

    public static ConversationResponse from(Conversation conversation) {
        return new ConversationResponse(conversation.id(), conversation.profileId(), conversation.messages());
    }
}
