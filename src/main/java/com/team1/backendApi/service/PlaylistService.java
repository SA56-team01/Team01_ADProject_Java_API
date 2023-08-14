package com.team1.backendApi.service;

import java.util.List;

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.PlaylistDto;

public interface PlaylistService {

    public List<PlaylistDto> getPlaylistsByUserId(Long userId);

    public Playlist savePlaylist(Playlist playlist);
    
}
