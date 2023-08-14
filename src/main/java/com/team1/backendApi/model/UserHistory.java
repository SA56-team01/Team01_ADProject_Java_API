package com.team1.backendApi.model;

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

    // @Column(name = "spotify_userId", nullable = false)
    // private String spotifyUserId;

    private double latitude;

    private double longitude;

    @Column(name = "spotify_track_id")
    private String spotifyTrackId;

    @Column(name = "timestamp")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String timestamp;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserHistory() {
    }

    public UserHistory(Long id, double latitude, double longitude, String spotifyTrackId,
            String timestamp, User user) {
        this.id = id;
        //this.spotifyUserId = user.getSpotifyUserId();
        this.latitude = latitude;
        this.longitude = longitude;
        this.spotifyTrackId = spotifyTrackId;
        this.timestamp = timestamp;
        this.user = user;
    }

    
}
