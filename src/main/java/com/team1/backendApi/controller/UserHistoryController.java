package com.team1.backendApi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team1.backendApi.model.User;
import com.team1.backendApi.model.UserHistory;
import com.team1.backendApi.model.UserHistoryDto;
import com.team1.backendApi.service.UserHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserHistoryController {

    @Autowired
    private UserHistoryService userHistoryService;

    private final Logger logger = LoggerFactory.getLogger(UserHistoryController.class);

    @GetMapping("/user/history") //ML
    public ResponseEntity<List<UserHistory>> getUserHistory() {
        List<UserHistory> historyEntries = userHistoryService.getUserHistory();
        return ResponseEntity.ok(historyEntries);
    }

    // @PostMapping("/user-history") //android
    // public ResponseEntity<String> addUserHistory(@RequestBody UserHistoryDto userHistoryDto) {
    //     try {
    //         userHistoryService.addUserHistory(userHistoryDto);
    //         return ResponseEntity.ok("User history added successfully");
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding user history");
    //     }
    // }

    @PostMapping("/userHistory") //android
    public ResponseEntity<String> addUserHistory(@RequestBody UserHistoryDto userHistoryDto,
                                                 @RequestParam String spotifyUserId) {
        try {
            userHistoryService.addUserHistory(userHistoryDto, spotifyUserId);
            return ResponseEntity.ok("User history added successfully.");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }

}


