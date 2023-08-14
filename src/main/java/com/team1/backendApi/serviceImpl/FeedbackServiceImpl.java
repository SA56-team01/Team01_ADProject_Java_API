package com.team1.backendApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.backendApi.model.Feedback;
import com.team1.backendApi.repository.FeedbackRepository;
import com.team1.backendApi.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    
    @Autowired
    FeedbackRepository feedbackRepo;

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbackRepo.save(feedback);
    }
}
