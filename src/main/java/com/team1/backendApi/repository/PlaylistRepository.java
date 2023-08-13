package com.team1.backendApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PlaylistRepository extends JpaRepository<Playlist, Integer>{
    
}
