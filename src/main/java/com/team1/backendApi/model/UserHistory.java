package com.team1.backendApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="User_History")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;

    private double longitude;

    @Column(name = "spotify_track_id")
    private String spotifyTrackId;

    @Column(name = "timestamp")
    private String timestamp;
    
    @ManyToOne
    @JoinColumn(name = "spotify_user_id")
    private User user;

    public UserHistory(User user, double latitude, double longitude, String spotifyTrackId, String timestamp){
        this.user = user;
        this.latitude = latitude;
        this.longitude = longitude;
        this.spotifyTrackId = spotifyTrackId;
        this.timestamp = timestamp;
    }
    
}
