package com.team1.backendApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team1.backendApi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findBySpotifyUserId(String spotifyUserId);

    Optional<User> findById(Long userId);
}
