package com.team1.backendApi.service;

import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    // Inject any necessary repositories or dependencies here if needed

    public boolean saveFeedback(String feedback) {
        // Logic to save the feedback into the database
        // Implement your database storage here

        return true; // Return true if the feedback is successfully saved; false otherwise
    }

    public MetricsResponse getMetrics() {
        MetricsResponse metricsResponse = new MetricsResponse();
        // Implement logic to retrieve metrics data from the database or any other source
        // Set the metrics data in the metricsResponse object

        return metricsResponse;
    }
}

