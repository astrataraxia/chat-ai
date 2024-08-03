package com.example.tinderaibackend.profiles.repository;

import com.example.tinderaibackend.profiles.entitiy.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {

}
