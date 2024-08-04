package com.example.tinderaibackend.profiles.service;

import com.example.tinderaibackend.profiles.entitiy.Profile;
import com.example.tinderaibackend.profiles.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public Profile getRandomProfile() {
        return profileRepository.getRandomProfile();
    }
}
