package com.team1.backendApi.service;

import com.team1.backendApi.model.User;
import java.util.List;

public interface UserService {
  User getUserBySpotifyUserId(String spotifyUserId);

  User getUserById(Long userId);
  void createNewUser(String spotifyUserId);
  List<User> getAllUsers();

  User createUser(String spotifyUserId, String userEmail);
}
