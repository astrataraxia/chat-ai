package com.example.tinderaibackend.matches.dto;

import com.example.tinderaibackend.matches.entity.Match;
import com.example.tinderaibackend.profiles.entitiy.Profile;

public record MatchResponse(
        String id,
        Profile profile,
        String conversationId
) {
    public static MatchResponse from(Match save) {
        return new MatchResponse(save.id(), save.profile(), save.conversationId());
    }
}
