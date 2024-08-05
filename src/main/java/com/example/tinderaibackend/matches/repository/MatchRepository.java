package com.example.tinderaibackend.matches.repository;

import com.example.tinderaibackend.matches.entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<Match, String> {
}
