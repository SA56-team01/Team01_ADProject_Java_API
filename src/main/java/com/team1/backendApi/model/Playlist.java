package com.team1.backendApi.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table (name="playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "timestamp_created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate timestampCreated;

    @Column(name = "ms_played")
    private int msPlayed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playlist")
    private List<PlaylistSong> playlistSongs;

    public Playlist() {
       
    }

    public Playlist(Long id, String name, LocalDate timestampCreated, int msPlayed, User user,
            List<PlaylistSong> playlistSongs) {
        this.id = id;
        this.name = name;
        this.timestampCreated = timestampCreated;
        this.msPlayed = msPlayed;
        this.user = user;
        this.playlistSongs = playlistSongs;
    }

}