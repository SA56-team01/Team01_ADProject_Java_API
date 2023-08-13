package com.team1.backendApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team1.backendApi.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
    
}
