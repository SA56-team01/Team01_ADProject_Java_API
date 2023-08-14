package com.team1.backendApi.serviceImpl;

import com.team1.backendApi.model.Playlist;
import com.team1.backendApi.model.User;
import com.team1.backendApi.model.UserHistory;
import com.team1.backendApi.repository.UserHistoryRepository;
import com.team1.backendApi.repository.UserRepository;
import com.team1.backendApi.service.UserHistoryService;
import com.team1.backendApi.service.UserService;

import jakarta.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserHistoryServiceImpl implements UserHistoryService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Resource
    UserService userService;

    // public void addUserHistory(UserHistoryDto userHistoryDto) {
    //     UserHistory userHistory = new UserHistory();
    //     userHistory.setUser(userService.getUserBySpotifyUserId(userHistoryDto.getSpotifyUserId()));
    //     userHistory.setTimestamp(userHistoryDto.getTimestamp());
    //     userHistory.setLatitude(userHistoryDto.getLatitude());
    //     userHistory.setLongitude(userHistoryDto.getLongitude());
    //     userHistory.setSpotifyTrackId(userHistoryDto.getSpotifyTrackId());

    //     userHistoryRepository.save(userHistory);
    // }

    @Override
    public UserHistory addUserHistory(UserHistory userHistory) {
    
        return userHistoryRepository.save(userHistory);
    }
    

    @Override
    public List<UserHistory> getUserHistory() {
        
        List<UserHistory> userHistoryEntities = userHistoryRepository.findAll();
        
        List<UserHistory> userHistoryEntries = convertToDto(userHistoryEntities);
        
        return userHistoryEntries;
    }
    
    // Method to convert UserHistory entities to UserHistory DTOs
    private List<UserHistory> convertToDto(List<UserHistory> userHistoryEntities) {
        List<UserHistory> userHistoryEntries = new ArrayList<>();
        
        for (UserHistory entity : userHistoryEntities) {
            UserHistory dto = new UserHistory();
            dto.setTimestamp(entity.getTimestamp());
            dto.setLatitude(entity.getLatitude());
            dto.setLongitude(entity.getLongitude());
            dto.setSpotifyTrackId(entity.getSpotifyTrackId());
            
            userHistoryEntries.add(dto);
        }
        
        return userHistoryEntries;
    }
    
}