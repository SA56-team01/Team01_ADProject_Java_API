package com.team1.backendApi.controller;

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.PlaylistDto;
import com.team1.backendApi.model.PlaylistSong;
import com.team1.backendApi.model.User;
import com.team1.backendApi.service.PlaylistService;
import com.team1.backendApi.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

  @Autowired
  private PlaylistService playlistService;

  @Autowired
  private UserService userService;

  @GetMapping("/allPlaylists")
  public ResponseEntity<List<Playlist>> getAllPlaylists() {
    List<Playlist> playlists = playlistService.getAllPlaylists();
    return ResponseEntity.ok(playlists);
  }

  @GetMapping("/user/{spotifyUserId}")
  public ResponseEntity<List<PlaylistDto>> getPlaylistsBySpotifyUserId(
    @PathVariable String spotifyUserId
  ) {
    try {
      List<Playlist> playlists = playlistService.getPlaylistsBySpotifyUserId(
        spotifyUserId
      );

      List<PlaylistDto> simplifiedPlaylists = new ArrayList<>();
      for (Playlist playlist : playlists) {
        PlaylistDto PlaylistDto = new PlaylistDto(
          playlist.getId(),
          playlist.getPlaylistName(),
          playlist.getSpotifyPlaylistId(),
          playlist.getTimestamp(),
          playlist.getLongitude(),
          playlist.getLatitude(),
          playlist.getSeedTracks(),
          playlist.getTargetAcousticness(),
          playlist.getTargetDanceability(),
          playlist.getTargetEnergy(),
          playlist.getTargetInstrumentalness(),
          playlist.getTargetKey(),
          playlist.getTargetLiveness(),
          playlist.getTargetLoudness(),
          playlist.getTargetMode(),
          playlist.getTargetSpeechiness(),
          playlist.getTargetTempo(),
          playlist.getTargetTimeSignature(),
          playlist.getTargetValence(),
          playlist.getType(),
          playlist.getPlaylistSongs()
        );
        simplifiedPlaylists.add(PlaylistDto);
      }

      return ResponseEntity.ok(simplifiedPlaylists);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PostMapping("/store")
  public ResponseEntity<String> storePlaylist(
    @RequestParam("spotify_userId") String spotifyUserId,
    @RequestBody Playlist playlist
  ) {
    try {
      User user = userService.getUserBySpotifyUserId(spotifyUserId);
      if (user == null) {
        userService.createNewUser(spotifyUserId);
        //                return new ResponseEntity<String>("no user found for user id"+ spotifyUserId , HttpStatus.INTERNAL_SERVER_ERROR);
      }

      Playlist newPlaylist = new Playlist();
      newPlaylist.setUser(userService.getUserBySpotifyUserId(spotifyUserId));
      newPlaylist.setPlaylistName(playlist.getPlaylistName());
      newPlaylist.setSpotifyPlaylistId(playlist.getSpotifyPlaylistId());
      newPlaylist.setTimestamp(playlist.getTimestamp());
      newPlaylist.setLongitude(playlist.getLongitude());
      newPlaylist.setLatitude(playlist.getLatitude());
      newPlaylist.setSeedTracks(playlist.getSeedTracks());
      newPlaylist.setTargetAcousticness(playlist.getTargetAcousticness());
      newPlaylist.setTargetDanceability(playlist.getTargetDanceability());
      newPlaylist.setTargetEnergy(playlist.getTargetEnergy());
      newPlaylist.setTargetInstrumentalness(
        playlist.getTargetInstrumentalness()
      );
      newPlaylist.setTargetKey(playlist.getTargetKey());
      newPlaylist.setTargetLiveness(playlist.getTargetLiveness());
      newPlaylist.setTargetLoudness(playlist.getTargetLoudness());
      newPlaylist.setTargetMode(playlist.getTargetMode());
      newPlaylist.setTargetSpeechiness(playlist.getTargetSpeechiness());
      newPlaylist.setTargetTempo(playlist.getTargetTempo());
      newPlaylist.setTargetTimeSignature(playlist.getTargetTimeSignature());
      newPlaylist.setTargetValence(playlist.getTargetValence());
      newPlaylist.setType(playlist.getType());

      List<PlaylistSong> playlistSongs = playlist.getPlaylistSongs();
      for (PlaylistSong song : playlistSongs) {
        song.setPlaylist(newPlaylist);
      }

      newPlaylist.setPlaylistSongs(playlistSongs);

      playlistService.savePlaylist(newPlaylist);

      return new ResponseEntity<>("Playlist successfully saved", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(
        "An error occurred" + e.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }
}
