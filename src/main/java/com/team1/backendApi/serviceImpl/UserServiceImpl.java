package com.team1.backendApi.serviceImpl;

import com.team1.backendApi.model.User;
import com.team1.backendApi.repository.UserRepository;
import com.team1.backendApi.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  public User createUser(String spotifyUserId, String userEmail) {
    // Create a new user with default userMarket value
    User newUser = new User(spotifyUserId, "SG", userEmail);

    return userRepository.save(newUser);
  }

  @Override
  public User getUserBySpotifyUserId(String spotifyUserId) {
    return userRepository.findBySpotifyUserId(spotifyUserId);
  }

  @Override
  public User getUserById(Long userId) {
    return userRepository
      .findById(userId)
      .orElseThrow(() -> new ResourceNotFoundException());
  }

  @Override
  public void createNewUser(String spotifyUserId) {
    User newUser = new User();
    newUser.setSpotifyUserId(spotifyUserId);
    userRepository.save(newUser);
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
