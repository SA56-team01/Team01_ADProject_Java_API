package com.team1.backendApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team1.backendApi.model.UserHistoryDto;
import com.team1.backendApi.service.UserHistoryService;

@RestController
public class UserHistoryController {

    @Autowired
    UserHistoryService userHistoryService;

    @PostMapping("/api/user-history")
    public ResponseEntity<String> addUserHistory(@RequestBody UserHistoryDto userHistoryDto) {
        try {
            userHistoryService.addUserHistory(userHistoryDto);
            return ResponseEntity.ok("User history added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding user history");
        }
    }
}

