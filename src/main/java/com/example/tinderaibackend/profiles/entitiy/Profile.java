package com.example.tinderaibackend.profiles.entitiy;

import com.example.tinderaibackend.profiles.entitiy.enums.Gender;

public record Profile(
        String id,
        String firstName,
        String lastName,
        int age,
        String ethnicity,
        Gender gender,
        String bio,
        String imageUrl,
        String myersBriggsPersonalityType
) {
}
