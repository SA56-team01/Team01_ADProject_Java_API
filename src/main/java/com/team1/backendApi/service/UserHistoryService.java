package com.team1.backendApi.service;

import java.util.List;

import com.team1.backendApi.model.UserHistory;

public interface UserHistoryService {

    // UserHistoryDto addUserHistory(UserHistoryDto userHistoryDto);
    void addUserHistory(UserHistory userHistory, String spotifyUserId);
    
    public List<UserHistory> getUserHistory();
    
}
