package com.team1.backendApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.PlaylistSong;

@Repository
public interface PlaylistSongRepository extends JpaRepository<PlaylistSong, Integer>{

    // void saveAll(List<PlaylistSong> asList);

    // Object findById(Long id);
    
}
