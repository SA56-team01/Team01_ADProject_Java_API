package com.team1.backendApi.controller;

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

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.PlaylistDto;
import com.team1.backendApi.model.PlaylistSong;
import com.team1.backendApi.model.User;
import com.team1.backendApi.service.PlaylistService;
import com.team1.backendApi.service.UserService;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Playlist>> getPlaylistsByUserId(@PathVariable Long userId) {
        List<Playlist> playlists = playlistService.getPlaylistsByUserId(userId);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @PostMapping("/store")
    public ResponseEntity<String> storePlaylist(@RequestParam("user_id") Long userId, @RequestBody Playlist playlist) {

        try{
            User user = userService.getUserById(userId);
            if(user == null){
                return new ResponseEntity<String>("no user found for user id"+ userId , HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
            Playlist newPlaylist = new Playlist();
            newPlaylist.setUser(userService.getUserById(userId));
            newPlaylist.setPlaylistName(playlist.getPlaylistName());
            newPlaylist.setTimestampCreated(playlist.getTimestampCreated());
            newPlaylist.setLongitudeCreated(playlist.getLongitudeCreated());
            newPlaylist.setLatitudeCreated(playlist.getLatitudeCreated());
            newPlaylist.setSeedTracks(playlist.getSeedTracks());
            newPlaylist.setTargetAcousticness(playlist.getTargetAcousticness());
            newPlaylist.setTargetDanceability(playlist.getTargetDanceability());
            newPlaylist.setTargetEnergy(playlist.getTargetEnergy());
            newPlaylist.setTargetInstrumentalness(playlist.getTargetInstrumentalness());
            newPlaylist.setTargetKey(playlist.getTargetKey());
            newPlaylist.setTargetLiveness(playlist.getTargetLiveness());
            newPlaylist.setTargetLoudenes(playlist.getTargetLoudenes());
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
        }
        catch(Exception e){
            return new ResponseEntity<String>("An error occurred" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        
        }
    }
}






