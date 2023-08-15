package com.team1.backendApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team1.backendApi.model.Feedback;
import com.team1.backendApi.model.User;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

    List<Feedback> findByUser(User user);
  
}
