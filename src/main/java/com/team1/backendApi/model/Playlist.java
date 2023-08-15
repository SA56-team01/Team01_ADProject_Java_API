package com.team1.backendApi.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("user")
@Entity
@Table (name="playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="playlist_id")
    private Long id;

    @Column(name="playlist_name")
    private String playlistName;

    @Column(name = "timestamp")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String timestamp;

    @Column(name="longitude")
    private Double longitude;

    @Column(name="latitude")
    private Double latitude;

    @Column(name="seed_tracks")
    private String seedTracks;

    @Column(name="target_acousticness")
    private double targetAcousticness;

    @Column(name="target_danceability")
    private double targetDanceability;

    @Column(name="target_energy")
    private double targetEnergy;

    @Column(name="target_instrumentalness")
    private double targetInstrumentalness;

    @Column(name="target_key")
    private double targetKey;

    @Column(name="target_liveness")
    private double targetLiveness;

    @Column(name="target_loudness")
    private double targetLoudenes;

    @Column(name="target_mode")
    private double targetMode;

    @Column(name="target_speechiness")
    private double targetSpeechiness;

    @Column(name="target_tempo")
    private double targetTempo;

    @Column(name="target_time_signature")
    private double targetTimeSignature;

    @Column(name="target_valence")
    private double targetValence;

    @Column(name="type")
    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "playlist", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<PlaylistSong> playlistSongs;


    
}