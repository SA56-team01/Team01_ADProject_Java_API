package com.team1.backendApi.service;

import com.team1.backendApi.model.Feedback;
import com.team1.backendApi.model.User;
import java.util.List;
import java.util.Map;

public interface FeedbackService {
  void saveFeedback(Feedback feedback);

  List<Feedback> getFeedbackByUser(User user);

  // List<Feedback> getFeedbackBySpotifyUserId(String spotifyUserId);
  List<Map<String, Object>> getFeedbackBySpotifyUserId(String spotifyUserId);

  List<Map<String, Object>> getAllFeedback();
}
