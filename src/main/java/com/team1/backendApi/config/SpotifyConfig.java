package com.team1.backendApi.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifyConfig {

    private String spotifyApiBaseUrl = "https://api.spotify.com";
    private String accessToken = "BQCH-J4aUm8CiIcpEB33fQ-Ed8NHw76O6nn-cdrlyX3KuBqhPIS9MXd0r65KnIxSeEQB6AtDyuH_xedWWKgxp-gc5mCviDH0FwMP5ImnOcDbaEpLouU";
    private String artistId = "0TnOYISbd1XYRBk9myaseg";
    private String userId = "314dljstnm6akwq5lzpb3othud3m";

    public String getSpotifyApiBaseUrl() {
        return spotifyApiBaseUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getUserId() {
        return userId;
    }
}


