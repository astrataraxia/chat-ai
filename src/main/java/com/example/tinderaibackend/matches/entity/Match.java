package com.example.tinderaibackend.matches.entity;

import com.example.tinderaibackend.profiles.entitiy.Profile;
import lombok.Builder;

public record Match(
        String id,
        Profile profile,
        String conversationId
) {
    @Builder
    public Match(String id, Profile profile, String conversationId) {
        this.id = id;
        this.profile = profile;
        this.conversationId = conversationId;
    }
}
