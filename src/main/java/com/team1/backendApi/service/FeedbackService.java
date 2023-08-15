package com.team1.backendApi.service;

import java.util.List;
import java.util.Map;

import com.team1.backendApi.model.Feedback;
import com.team1.backendApi.model.User;

public interface FeedbackService {
    void saveFeedback(Feedback feedback);
    List<Feedback> getFeedbackByUser(User user);
    //List<Feedback> getFeedbackBySpotifyUserId(String spotifyUserId);
    List<Map<String, Object>> getFeedbackBySpotifyUserId(String spotifyUserId);
}
