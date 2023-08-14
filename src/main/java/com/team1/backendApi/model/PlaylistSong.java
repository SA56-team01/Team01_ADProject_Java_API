package com.team1.backendApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="playlist_song")
public class PlaylistSong{
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;   

    public PlaylistSong() {}

    public PlaylistSong(Long id, Playlist playlist) {
        this.id = id;
        this.playlist = playlist;
    }
}
