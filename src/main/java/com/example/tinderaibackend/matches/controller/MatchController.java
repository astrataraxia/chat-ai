package com.example.tinderaibackend.matches.controller;

import com.example.tinderaibackend.matches.dto.CreateMatchRequest;
import com.example.tinderaibackend.matches.dto.MatchResponse;
import com.example.tinderaibackend.matches.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @CrossOrigin(origins = "*")
    @PostMapping("/matches")
    @ResponseStatus(HttpStatus.CREATED)
    public MatchResponse createNewMatch(@RequestBody CreateMatchRequest request) {
        return matchService.createNewMatch(request);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/matches")
    @ResponseStatus(HttpStatus.OK)
    public List<MatchResponse> getAllMatches() {
        return matchService.getAllMatches();
    }
}
