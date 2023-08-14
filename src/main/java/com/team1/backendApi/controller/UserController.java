package com.team1.backendApi.controller;

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

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.User;
import com.team1.backendApi.service.UserService;

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

        User user = userService.getUserById(userId);

        if (user == null) {
            String errorMessage = "User with ID " + userId + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

        List<Map<String, Object>> response = new ArrayList<>();

        for (Playlist playlist : user.getPlaylists()) {
            Map<String, Object> playlistMap = new HashMap<>();
            playlistMap.put("playlist_id", playlist.getId());
            playlistMap.put("user_id", playlist.getUser().getUserId());
            playlistMap.put("latitude_created", playlist.getLatitudeCreated());
            playlistMap.put("longitude_created", playlist.getLongitudeCreated());
            playlistMap.put("timestamp_created", playlist.getTimestampCreated());
            playlistMap.put("seed_tracks", Arrays.asList(playlist.getSeedTracks().split(",")));
            playlistMap.put("target_acousticness", playlist.getTargetAcousticness());
            playlistMap.put("target_danceability", playlist.getTargetDanceability());
            playlistMap.put("target_energy", playlist.getTargetEnergy());
            playlistMap.put("target_instrumentalness", playlist.getTargetInstrumentalness());
            playlistMap.put("target_key", playlist.getTargetKey());
            playlistMap.put("target_liveness", playlist.getTargetLiveness());
            playlistMap.put("target_loudness", playlist.getTargetLoudenes());
            playlistMap.put("target_mode", playlist.getTargetMode());
            playlistMap.put("target_speechiness", playlist.getTargetSpeechiness());
            playlistMap.put("target_tempo", playlist.getTargetTempo());
            playlistMap.put("target_time_signature", playlist.getTargetTimeSignature());
            playlistMap.put("target_valence", playlist.getTargetValence());
            playlistMap.put("type", playlist.getType());

            response.add(playlistMap);
        }
        return ResponseEntity.ok(response);
    }   


}