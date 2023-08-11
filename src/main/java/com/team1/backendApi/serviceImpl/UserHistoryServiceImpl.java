package com.team1.backendApi.serviceImpl;

import com.team1.backendApi.model.UserHistory;
import com.team1.backendApi.model.UserHistoryDto;
import com.team1.backendApi.repository.UserHistoryRepository;
import com.team1.backendApi.service.UserHistoryService;
import com.team1.backendApi.service.UserService;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class UserHistoryServiceImpl implements UserHistoryService{

    @Resource
    UserHistoryRepository userHistoryRepository;

    @Resource
    UserService userService;

    public void addUserHistory(UserHistoryDto userHistoryDto) {
        UserHistory userHistory = new UserHistory();
        userHistory.setUser(userService.getUserBySpotifyUserId(userHistoryDto.getSpotifyUserId()));
        userHistory.setTimestamp(userHistoryDto.getTimestamp());
        userHistory.setLatitude(userHistoryDto.getLatitude());
        userHistory.setLongitude(userHistoryDto.getLongitude());

        userHistoryRepository.save(userHistory);
    }
    
}