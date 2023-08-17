package com.team1.backendApi.controller;

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.User;
import com.team1.backendApi.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  UserService userService;

  // @GetMapping("/details")
  // public ResponseEntity<?> getUserData1(@RequestParam("user_id") Long userId) {

  //     User user = userService.getUserById(userId);

  //     if (user == null) {
  //         String errorMessage = "User with ID " + userId + " not found.";
  //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
  //     }

  //     return ResponseEntity.ok(user);
  // }

  @GetMapping("/detail")
  public ResponseEntity<?> getUserData(@RequestParam("user_id") Long userId) {
    try {
      User user = userService.getUserById(userId);

      if (user == null) {
        String errorMessage = "User with ID " + userId + " not found.";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
      }

      List<Map<String, Object>> response = new ArrayList<>();

      for (Playlist playlist : user.getPlaylists()) {
        Map<String, Object> playlistMap = new HashMap<>();
        playlistMap.put("playlist_id", playlist.getId());
        playlistMap.put(
          "spotify_user_id",
          playlist.getUser().getSpotifyUserId()
        );
        playlistMap.put("playlist_name", playlist.getPlaylistName());
        playlistMap.put("spotify_playlist_id", playlist.getSpotifyPlaylistId());
        playlistMap.put("latitude", playlist.getLatitude());
        playlistMap.put("longitude", playlist.getLongitude());
        playlistMap.put("timestamp", playlist.getTimestamp());
        playlistMap.put(
          "seed_tracks",
          Arrays.asList(playlist.getSeedTracks().split(","))
        );
        playlistMap.put(
          "target_acousticness",
          playlist.getTargetAcousticness()
        );
        playlistMap.put(
          "target_danceability",
          playlist.getTargetDanceability()
        );
        playlistMap.put("target_energy", playlist.getTargetEnergy());
        playlistMap.put(
          "target_instrumentalness",
          playlist.getTargetInstrumentalness()
        );
        playlistMap.put("target_key", playlist.getTargetKey());
        playlistMap.put("target_liveness", playlist.getTargetLiveness());
        playlistMap.put("target_loudness", playlist.getTargetLoudness());
        playlistMap.put("target_mode", playlist.getTargetMode());
        playlistMap.put("target_speechiness", playlist.getTargetSpeechiness());
        playlistMap.put("target_tempo", playlist.getTargetTempo());
        playlistMap.put(
          "target_time_signature",
          playlist.getTargetTimeSignature()
        );
        playlistMap.put("target_valence", playlist.getTargetValence());
        playlistMap.put("type", playlist.getType());

        response.add(playlistMap);
      }
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
    @GetMapping("/alldetails")
  public ResponseEntity<?> getAllUsersData() {
    try {
        List<User> users = userService.getAllUsers(); // Assuming you have a method to retrieve all users

        List<Map<String, Object>> response = new ArrayList<>();

        for (User user : users) {
            Map<String, Object> userData = new HashMap<>();
            userData.put("user_id", user.getUserId());
            userData.put("spotify_user_id", user.getSpotifyUserId());
            userData.put("user_market", user.getUserMarket());
            userData.put("email", user.getUserEmail());

            List<Map<String, Object>> playlistsData = new ArrayList<>();

            for (Playlist playlist : user.getPlaylists()) {
                Map<String, Object> playlistData = new HashMap<>();
                playlistData.put("playlist_id", playlist.getId());
                playlistData.put("playlist_name", playlist.getPlaylistName());
                playlistData.put("spotify_playlist_id", playlist.getSpotifyPlaylistId());
                playlistData.put("latitude", playlist.getLatitude());
                playlistData.put("longitude", playlist.getLongitude());
                playlistData.put("timestamp", playlist.getTimestamp());
                playlistData.put("seed_tracks", Arrays.asList(playlist.getSeedTracks().split(",")));
                playlistData.put("target_acousticness", playlist.getTargetAcousticness());
                playlistData.put("target_danceability", playlist.getTargetDanceability());
                playlistData.put("target_energy", playlist.getTargetEnergy());
                playlistData.put("target_instrumentalness", playlist.getTargetInstrumentalness());
                playlistData.put("target_key", playlist.getTargetKey());
                playlistData.put("target_liveness", playlist.getTargetLiveness());
                playlistData.put("target_loudness", playlist.getTargetLoudness());
                playlistData.put("target_mode", playlist.getTargetMode());
                playlistData.put("target_speechiness", playlist.getTargetSpeechiness());
                playlistData.put("target_tempo", playlist.getTargetTempo());
                playlistData.put("target_time_signature", playlist.getTargetTimeSignature());
                playlistData.put("target_valence", playlist.getTargetValence());
                playlistData.put("type", playlist.getType());

                playlistsData.add(playlistData);
            }

            userData.put("playlists", playlistsData);
            response.add(userData);
        }

        return ResponseEntity.ok(response);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}


  
}
