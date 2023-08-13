package com.team1.backendApi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserHistoryDto {
    private String spotifyUserId;
    private LocalDateTime timestamp;
    private double latitude;
    private double longitude;



    public UserHistoryDto(String spotifyUserId, LocalDateTime timestamp, double latitude, double longitude) {
        this.spotifyUserId = spotifyUserId;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    
}
