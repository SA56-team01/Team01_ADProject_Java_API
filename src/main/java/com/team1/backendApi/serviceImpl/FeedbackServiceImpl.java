package com.team1.backendApi.serviceImpl;

import com.team1.backendApi.model.Feedback;
import com.team1.backendApi.model.User;
import com.team1.backendApi.model.UserHistory;
import com.team1.backendApi.repository.FeedbackRepository;
import com.team1.backendApi.service.FeedbackService;
import com.team1.backendApi.service.UserService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

  @Autowired
  FeedbackRepository feedbackRepo;

  private final UserService userService;

  @Autowired
  public FeedbackServiceImpl(UserService userService) {
    this.userService = userService; // Initialize UserService
  }

  @Override
  public void saveFeedback(Feedback feedback) {
    feedbackRepo.save(feedback);
  }

  @Override
  public List<Feedback> getFeedbackByUser(User user) {
    return feedbackRepo.findByUser(user);
  }

  @Override
  public List<Map<String, Object>> getFeedbackBySpotifyUserId(
    String spotifyUserId
  ) {
    User user = userService.getUserBySpotifyUserId(spotifyUserId);
    if (user == null) {
      return Collections.emptyList();
    }

    List<Feedback> feedbackList = feedbackRepo.findByUser(user);
    List<Map<String, Object>> responseList = new ArrayList<>();

    for (Feedback feedback : feedbackList) {
      Map<String, Object> feedbackMap = new HashMap<>();
      feedbackMap.put("ts", feedback.getFbTimestamp());

      // Loop through userHistories associated with the user
      for (UserHistory userHistory : user.getUserHistories()) {
        feedbackMap.put("latitude", userHistory.getLatitude());
        feedbackMap.put("longitude", userHistory.getLongitude());
        feedbackMap.put("Spotify_track_id", userHistory.getSpotifyTrackId());
        feedbackMap.put("spotifyUserId", user.getSpotifyUserId());

        responseList.add(feedbackMap);
      }
    }

    return responseList;
  }

  @Override
  public List<Map<String, Object>> getAllFeedback() {
    List<Feedback> feedbacks = feedbackRepo.findAll();

    return feedbacks
      .stream()
      .map(feedback -> {
        Map<String, Object> map = new HashMap<>();
        map.put("feedback_id", feedback.getId());
        map.put("feedback_text", feedback.getFeedbackText());
        map.put("fb_timestamp", feedback.getFbTimestamp());
        map.put("user_id", feedback.getUser().getUserId()); // Assuming the User entity has an Id field
        map.put("spotify_user_id", feedback.getSpotifyUserId()); // Even though it's a transient field, if it has
        // value you can map it.
        return map;
      })
      .collect(Collectors.toList());
  }
}
