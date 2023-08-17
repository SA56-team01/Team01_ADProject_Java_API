package com.team1.backendApi.service;

import com.team1.backendApi.model.Playlist;
import java.util.List;

public interface PlaylistService {
  public List<Playlist> getPlaylistsBySpotifyUserId(String spotifyUserId);

  public Playlist savePlaylist(Playlist playlist);

  public List<Playlist> getAllPlaylists();
}
