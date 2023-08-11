package com.team1.backendApi.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="User_History")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "spotify_userId", nullable = false)
    private String spotifyUserId;

    private double latitude;

    private double longitude;

    @Column(name = "spotify_track_id")
    private String spotifyTrackId;

    @Column(name = "timestamp")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;   
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserHistory() {
    }

    public UserHistory(Long id, String spotifyUserId, double latitude, double longitude, String spotifyTrackId,
            LocalDateTime timestamp, User user) {
        this.id = id;
        this.spotifyUserId = spotifyUserId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.spotifyTrackId = spotifyTrackId;
        this.timestamp = timestamp;
        this.user = user;
    }

    
}
