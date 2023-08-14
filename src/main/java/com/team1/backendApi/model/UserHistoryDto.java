package com.team1.backendApi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserHistoryDto {
    private String spotifyUserId;
    private String spotifyTrackId;
    private String timestamp;
    private double latitude;
    private double longitude;


    public UserHistoryDto() {
        // Default constructor
    }

    public UserHistoryDto(String spotifyUserId, String spotifyTrackId, String timestamp, double latitude,
            double longitude) {
        this.spotifyUserId = spotifyUserId;
        this.spotifyTrackId = spotifyTrackId;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
