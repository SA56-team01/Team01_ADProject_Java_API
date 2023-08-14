package com.team1.backendApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.team1.backendApi.model.User;
import com.team1.backendApi.repository.UserRepository;
import com.team1.backendApi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public User getUserBySpotifyUserId(String spotifyUserId) {
        return userRepo.findBySpotifyUserId(spotifyUserId);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException());
    }
    
}
