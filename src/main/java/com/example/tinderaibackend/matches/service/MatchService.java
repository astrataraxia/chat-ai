package com.example.tinderaibackend.matches.service;

import com.example.tinderaibackend.conversations.entity.Conversation;
import com.example.tinderaibackend.conversations.repository.ConversationRepository;
import com.example.tinderaibackend.matches.dto.CreateMatchRequest;
import com.example.tinderaibackend.matches.dto.MatchResponse;
import com.example.tinderaibackend.matches.entity.Match;
import com.example.tinderaibackend.matches.repository.MatchRepository;
import com.example.tinderaibackend.profiles.entitiy.Profile;
import com.example.tinderaibackend.profiles.repository.ProfileRepository;
import com.soundicly.jnanoidenhanced.jnanoid.NanoIdUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final ConversationRepository conversationRepository;
    private final ProfileRepository profileRepository;
    private final MatchRepository matchRepository;

    public MatchResponse createNewMatch(CreateMatchRequest request) {
        Profile profile = profileRepository.findById(request.profileId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Unable to find a profile with ID" + request.profileId()));

        //TODO: Make sure there are no existing conversation with this profile already
        Conversation conversation = new Conversation(
                NanoIdUtils.randomNanoId(),
                profile.id(),
                new ArrayList<>());
        conversationRepository.save(conversation);

        Match match = Match.builder()
                .id(NanoIdUtils.randomNanoId())
                .profile(profile)
                .conversationId(conversation.id())
                .build();

        Match save = matchRepository.save(match);

        return MatchResponse.from(save);
    }

    public List<MatchResponse> getAllMatches() {
        return matchRepository.findAll().stream()
                .map(MatchResponse::from)
                .toList();
    }
}
