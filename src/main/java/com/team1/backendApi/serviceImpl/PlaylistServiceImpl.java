package com.team1.backendApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.repository.PlaylistRepository;
import com.team1.backendApi.service.PlaylistService;

import jakarta.transaction.Transactional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> getPlaylistsBySpotifyUserId(String spotifyUserId) {
        return playlistRepository.findByUserSpotifyUserId(spotifyUserId);
    }

    @Override
    @Transactional
    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
