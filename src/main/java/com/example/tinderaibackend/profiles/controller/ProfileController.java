package com.example.tinderaibackend.profiles.controller;

import com.example.tinderaibackend.profiles.entitiy.Profile;
import com.example.tinderaibackend.profiles.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @CrossOrigin(origins = "*")
    @GetMapping("/profiles/random")
    public Profile getRandomProfile() {
        return profileService.getRandomProfile();
    }
}
