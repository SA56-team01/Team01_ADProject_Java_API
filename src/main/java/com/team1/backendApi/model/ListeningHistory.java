package com.team1.backendApi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="listening_history")
public class ListeningHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="listening_hist_id")
    private Long listeningHistId;

    // @ManyToOne
    // @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    // private User user;

    @Column(name = "played_at")
    private LocalDateTime playedAt;

    @Column(name = "spotify_track_id")
    private String spotifyTrackId;

    @Column(name = "spotify_track_uri")
    private String spotifyTrackUri;

    public ListeningHistory(){}

    public ListeningHistory(LocalDateTime playedAt, String spotifyTrackId, String spotifyTrackUri) {
        this.playedAt = playedAt;
        this.spotifyTrackId = spotifyTrackId;
        this.spotifyTrackUri = spotifyTrackUri;
    }

    public Long getListeningHistId() {
        return listeningHistId;
    }

    public void setListeningHistId(Long listeningHistId) {
        this.listeningHistId = listeningHistId;
    }

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(LocalDateTime playedAt) {
        this.playedAt = playedAt;
    }

    public String getSpotifyTrackId() {
        return spotifyTrackId;
    }

    public void setSpotifyTrackId(String spotifyTrackId) {
        this.spotifyTrackId = spotifyTrackId;
    }

    public String getSpotifyTrackUri() {
        return spotifyTrackUri;
    }

    public void setSpotifyTrackUri(String spotifyTrackUri) {
        this.spotifyTrackUri = spotifyTrackUri;
    }

    @Override
    public String toString() {
        return "ListeningHistory{" +
                "listeningHistId=" + listeningHistId +
                ", playedAt=" + playedAt +
                ", spotifyTrackId='" + spotifyTrackId + '\'' +
                ", spotifyTrackUri='" + spotifyTrackUri + '\'' +
                '}';
    }
}
