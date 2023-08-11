package com.team1.backendApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

import com.team1.backendApi.model.User;
import com.team1.backendApi.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OAuthController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> getUserInfo(@AuthenticationPrincipal OAuth2User oauth2User) {
        String spotifyUserId = oauth2User.getAttribute("id");
        User user = userService.getUserBySpotifyUserId(spotifyUserId);
        
        if (user != null) {
            return ResponseEntity.ok(user); // HTTP 200 OK with the User
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // HTTP 404 Not Found
        }
    }
}


