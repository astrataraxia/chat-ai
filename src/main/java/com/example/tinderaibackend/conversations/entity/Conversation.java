package com.example.tinderaibackend.conversations.entity;


import java.util.List;

public record Conversation(
    String id,
    String profileId,
    List<ChatMessage> messages
) {
}
