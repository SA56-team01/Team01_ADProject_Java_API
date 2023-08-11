package com.team1.backendApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.backendApi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findBySpotifyUserId(String spotifyUserId);
    
}
