package com.team1.backendApi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team1.backendApi.model.Feedback;
import com.team1.backendApi.model.User;
import com.team1.backendApi.service.FeedbackService;
import com.team1.backendApi.service.UserService;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;
    @Autowired
    UserService userService;

    @GetMapping("/feedback/test")
    public ResponseEntity<String> testFeedback() {
        return new ResponseEntity<String>("Success!!!!! Christynn ko chit dl", HttpStatus.OK);
    }

    @PostMapping("/feedback/save")
    public ResponseEntity<String> saveFeedback(@RequestParam("user_id") Long userId,
            @RequestParam("feedback_text") String feedbackText) {
        try {
            // Set the timestamp for the feedback
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);

            User user = userService.getUserById(userId);
            if (user == null) {
                return new ResponseEntity<String>("No User Found for userId: " + userId ,HttpStatus.INTERNAL_SERVER_ERROR);
            }

            // Initialize Feedback
            Feedback newFeedback = new Feedback();
            newFeedback.setUser(userService.getUserById(userId));
            newFeedback.setFeedbackText(feedbackText);
            newFeedback.setFbTimestamp(formattedDateTime);

            // Save feedback to db
            feedbackService.saveFeedback(newFeedback);

            return new ResponseEntity<>("Successfully Saved", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
