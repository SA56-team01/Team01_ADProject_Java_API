package com.team1.backendApi.controller;

import com.team1.backendApi.model.Feedback;
import com.team1.backendApi.model.User;
import com.team1.backendApi.service.FeedbackService;
import com.team1.backendApi.service.UserService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FeedbackController {

  @Autowired
  FeedbackService feedbackService;

  @Autowired
  UserService userService;

  @GetMapping("/feedback/test")
  public ResponseEntity<String> testFeedback() {
    return new ResponseEntity<String>("Success!!!!!", HttpStatus.OK);
  }

  @GetMapping("/feedback/data")
  public ResponseEntity<List<Map<String, Object>>> getFeedbackDataBySpotifyUserId(
    @RequestParam("spotify_user_id") String spotifyUserId
  ) {
    try {
      List<Map<String, Object>> feedbackList = feedbackService.getFeedbackBySpotifyUserId(
        spotifyUserId
      );

      return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/feedback/allFeedback")
  public ResponseEntity<List<Map<String, Object>>> getAllFeedbackData() {
    try {
      List<Map<String, Object>> feedbackList = feedbackService.getAllFeedback();

      return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // @PostMapping("/feedback/save")
  // public ResponseEntity<String> saveFeedback(@RequestParam("spotify_user_id")
  // String spotifyUserId,
  // @RequestParam("feedback_text") String feedbackText) {
  // try {
  // // Set the timestamp for the feedback
  // LocalDateTime currentDateTime = LocalDateTime.now();
  // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd
  // HH:mm:ss");
  // String formattedDateTime = currentDateTime.format(formatter);

  // User user=userService.getUserBySpotifyUserId(spotifyUserId);
  // //User user = userService.getUserById(userId);
  // if (user == null) {
  // return new ResponseEntity<String>("No User Found for userId: " +
  // spotifyUserId ,HttpStatus.INTERNAL_SERVER_ERROR);
  // }

  // // Initialize Feedback
  // Feedback newFeedback = new Feedback();
  // //newFeedback.setUser(userService.getUserBySpotifyUserId(spotifyUserId));
  // newFeedback.setUser(user);
  // newFeedback.setFeedbackText(feedbackText);
  // newFeedback.setFbTimestamp(formattedDateTime);

  // // Save feedback to db
  // feedbackService.saveFeedback(newFeedback);

  // return new ResponseEntity<>("Successfully Saved", HttpStatus.OK);

  // } catch (Exception e) {
  // return new ResponseEntity<String>("An error occurred: " + e.getMessage(),
  // HttpStatus.INTERNAL_SERVER_ERROR);
  // }
  // }
  @PostMapping("/feedback/save")
  public ResponseEntity<String> saveFeedback(
    @RequestParam("spotify_user_id") String spotifyUserId,
    @RequestParam("feedback_text") String feedbackText
  ) {
    try {
      // Set the timestamp for the feedback
      LocalDateTime currentDateTime = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
        "yyyy-MM-dd HH:mm:ss"
      );
      String formattedDateTime = currentDateTime.format(formatter);

      User user = userService.getUserBySpotifyUserId(spotifyUserId);

      if (user == null) {
        return new ResponseEntity<String>(
          "No User Found for userId: " + spotifyUserId,
          HttpStatus.INTERNAL_SERVER_ERROR
        );
      }

      // Initialize Feedback
      Feedback newFeedback = new Feedback();
      newFeedback.setUser(user); // Associate the correct user with the feedback
      newFeedback.setFeedbackText(feedbackText);
      newFeedback.setFbTimestamp(formattedDateTime);

      // Save feedback to db
      feedbackService.saveFeedback(newFeedback);

      return new ResponseEntity<>("Successfully Saved", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(
        "An error occurred: " + e.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }
}
