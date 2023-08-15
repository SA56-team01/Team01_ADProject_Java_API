package com.team1.backendApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.team1.backendApi.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    
    @Query("SELECT p FROM Playlist p WHERE p.user.spotifyUserId = :spotifyUserId")
    List<Playlist> findByUserSpotifyUserId(@Param("spotifyUserId") String spotifyUserId);
}

