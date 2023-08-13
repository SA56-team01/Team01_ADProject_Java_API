package com.team1.backendApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.PlaylistDto;
import com.team1.backendApi.service.PlaylistService;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PlaylistDto>> getPlaylistsByUserId(@PathVariable Long userId) {
        List<PlaylistDto> playlists = playlistService.getPlaylistsByUserId(userId);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @PostMapping("/store")
    public ResponseEntity<Playlist> storePlaylist(@RequestBody Playlist playlist) {
        Playlist savedPlaylist = playlistService.savePlaylist(playlist);
        return new ResponseEntity<>(savedPlaylist, HttpStatus.CREATED);
    }
}






