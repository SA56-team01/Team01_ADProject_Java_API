package com.team1.backendApi.service;

import java.util.List;

import com.team1.backendApi.model.Playlist;

public interface PlaylistService {

    public List<Playlist> getPlaylistsBySpotifyUserId(String spotifyUserId);

    public Playlist savePlaylist(Playlist playlist);
    
}
