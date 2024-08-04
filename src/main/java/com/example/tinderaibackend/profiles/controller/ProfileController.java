package com.example.tinderaibackend.profiles.controller;

import com.example.tinderaibackend.profiles.entitiy.Profile;
import com.example.tinderaibackend.profiles.service.ProfileCreationService;
import com.example.tinderaibackend.profiles.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileCreationService ProfileCreationService;
    private final ProfileService profileService;

    @GetMapping("/profiles/random")
    public Profile getRandomProfile() {
        return profileService.getRandomProfile();
    }
}
