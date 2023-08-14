package com.team1.backendApi.service;

import java.util.List;

import com.team1.backendApi.model.UserHistory;
import com.team1.backendApi.model.UserHistoryDto;

public interface UserHistoryService {

    // UserHistoryDto addUserHistory(UserHistoryDto userHistoryDto);
    void addUserHistory(UserHistoryDto userHistoryDto, String spotifyUserId);
    
    public List<UserHistory> getUserHistory();
    
}
