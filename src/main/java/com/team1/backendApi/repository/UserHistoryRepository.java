package com.team1.backendApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.team1.backendApi.model.UserHistory;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {

    @Query("SELECT u FROM UserHistory u WHERE u.user.spotifyUserId = :userId")
    List<UserHistory> findBySpotifyUserId(@Param("userId") String userId);
    
}
