package com.team1.backendApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team1.backendApi.model.User;
import com.team1.backendApi.model.UserHistory;
import com.team1.backendApi.service.UserHistoryService;
import com.team1.backendApi.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserHistoryController {

    @Autowired
    private UserHistoryService userHistoryService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/history/{spotifyUserId}") //ML
    public ResponseEntity<List<UserHistory>> getUserHistory(@PathVariable String spotifyUserId) {
        List<UserHistory> historyEntries = new ArrayList<UserHistory>();
        historyEntries = userHistoryService.getUserHistoryBySpotifyUserId(spotifyUserId);
        return ResponseEntity.ok(historyEntries);
    }

    @PostMapping("/userHistory") //android
    public ResponseEntity<String> addUserHistory(@RequestParam("spotify_userId") String spotifyUserId, @RequestBody UserHistory userHistory) {
        try {
            User user = userService.getUserBySpotifyUserId(spotifyUserId);

            if(user == null){
                return new ResponseEntity<String>("No user found for Spotify User Id: "+ spotifyUserId , HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
            UserHistory newUserHistory = new UserHistory();
            newUserHistory.setUser(user);
            newUserHistory.setSpotifyTrackId(userHistory.getSpotifyTrackId());
            newUserHistory.setLatitude(userHistory.getLatitude());
            newUserHistory.setLongitude(userHistory.getLongitude());
            newUserHistory.setTimestamp(userHistory.getTimestamp());
            
            userHistoryService.addUserHistory(newUserHistory);

            return ResponseEntity.ok("User history added successfully.");
        } 
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }

}


