package com.team1.backendApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.backendApi.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

    List<Playlist> findByUser_UserId(Long userId);
    
}
