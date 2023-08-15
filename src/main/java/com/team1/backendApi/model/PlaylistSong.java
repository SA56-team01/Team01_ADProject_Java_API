package com.team1.backendApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="playlist_song")
public class PlaylistSong{
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "track_id")
    private String trackId;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    @JsonBackReference
    private Playlist playlist;

    public PlaylistSong(String trackId, Playlist playlist) {
        this.trackId = trackId;
        this.playlist = playlist;
    }   

    
}
