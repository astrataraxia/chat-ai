package com.example.tinderaibackend.profiles.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "tinderai.character.user")
public class UserProfileProperties {

    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String ethnicity;
    private String gender;
    private String bio;
    private String imageUrl;
    private String myersBriggsPersonalityType;

}
