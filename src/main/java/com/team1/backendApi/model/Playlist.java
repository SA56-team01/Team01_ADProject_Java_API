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
    @Column(name="playlist_id")
    private Long id;

    @Column(name="playlist_name")
    private String playlistName;

    @Column(name = "timestamp_created")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String timestampCreated;

    @Column(name="longitude_created")
    private double longitudeCreated;

    @Column(name="latitude_created")
    private double latitudeCreated;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playlist")
    private List<PlaylistSong> playlistSongs;

    public Playlist() {
       
    }

    public Playlist(Long id, String playlistName, String timestampCreated, double longitudeCreated, double latitudeCreated, String seedTracks, double targetAcousticness, double targetDanceability, double targetEnergy, double targetInstrumentalness, double targetKey, double targetLiveness, double targetLoudenes, double targetMode, double targetSpeechiness, double targetTempo, double targetTimeSignature, double targetValence, String type, User user, List<PlaylistSong> playlistSongs) {
        this.id = id;
        this.playlistName = playlistName;
        this.timestampCreated = timestampCreated;
        this.longitudeCreated = longitudeCreated;
        this.latitudeCreated = latitudeCreated;
        this.seedTracks = seedTracks;
        this.targetAcousticness = targetAcousticness;
        this.targetDanceability = targetDanceability;
        this.targetEnergy = targetEnergy;
        this.targetInstrumentalness = targetInstrumentalness;
        this.targetKey = targetKey;
        this.targetLiveness = targetLiveness;
        this.targetLoudenes = targetLoudenes;
        this.targetMode = targetMode;
        this.targetSpeechiness = targetSpeechiness;
        this.targetTempo = targetTempo;
        this.targetTimeSignature = targetTimeSignature;
        this.targetValence = targetValence;
        this.type = type;

        this.user = user;
        this.playlistSongs = playlistSongs;
    }


}