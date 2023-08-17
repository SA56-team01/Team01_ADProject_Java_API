package com.team1.backendApi.service;

import java.util.List;

import com.team1.backendApi.model.User;

public interface UserService {

    User getUserBySpotifyUserId(String spotifyUserId);

    User getUserById(Long userId);
    void  createNewUser(String spotifyUserId);
    List<User> getAllUsers();
}
