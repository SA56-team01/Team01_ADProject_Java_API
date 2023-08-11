package com.team1.backendApi.serviceImpl;

import org.springframework.stereotype.Service;

import com.team1.backendApi.model.User;
import com.team1.backendApi.repository.UserRepository;
import com.team1.backendApi.service.UserService;

import jakarta.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    UserRepository userRepository;

    @Override
    public User getUserBySpotifyUserId(String spotifyUserId) {
        return userRepository.findBySpotifyUserId(spotifyUserId);
    }
    
}