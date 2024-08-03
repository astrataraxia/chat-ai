package com.example.tinderaibackend.conversations.repository;

import com.example.tinderaibackend.conversations.entity.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversationRepository extends MongoRepository<Conversation, String> {
}
