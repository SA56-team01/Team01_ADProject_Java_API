package com.team1.backendApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("user")
@Entity
@Table(name = "playlist")
public class Playlist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "playlist_id")
  private Long id;

  @Column(name = "playlist_name")
  private String playlistName;

  @Column(name = "spotify_playlist_id")
  private String spotifyPlaylistId;

  @Column(name = "timestamp")
  //@DateTimeFormat(pattern = "yyyy-MM-dd")
  private String timestamp;

  @Column(name = "longitude")
  private Double longitude;

  @Column(name = "latitude")
  private Double latitude;

  @Column(name = "seed_tracks")
  private String seedTracks;

  @Column(name = "target_acousticness")
  private double targetAcousticness;

  @Column(name = "target_danceability")
  private double targetDanceability;

  @Column(name = "target_energy")
  private double targetEnergy;

  @Column(name = "target_instrumentalness")
  private double targetInstrumentalness;

  @Column(name = "target_key")
  private double targetKey;

  @Column(name = "target_liveness")
  private double targetLiveness;

  @Column(name = "target_loudness")
  private double targetLoudness;

  @Column(name = "target_mode")
  private double targetMode;

  @Column(name = "target_speechiness")
  private double targetSpeechiness;

  @Column(name = "target_tempo")
  private double targetTempo;

  @Column(name = "target_time_signature")
  private double targetTimeSignature;

  @Column(name = "target_valence")
  private double targetValence;

  @Column(name = "type")
  private String type;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  @JsonIgnore
  private User user;

  @OneToMany(
    cascade = { CascadeType.PERSIST, CascadeType.MERGE },
    mappedBy = "playlist",
    fetch = FetchType.EAGER
  )
  @JsonManagedReference
  private List<PlaylistSong> playlistSongs;

  public Playlist(
    String playlistName,
    String spotifyPlaylistId,
    String timestamp,
    Double longitude,
    Double latitude,
    String seedTracks,
    double targetAcousticness,
    double targetDanceability,
    double targetEnergy,
    double targetInstrumentalness,
    double targetKey,
    double targetLiveness,
    double targetLoudness,
    double targetMode,
    double targetSpeechiness,
    double targetTempo,
    double targetTimeSignature,
    double targetValence,
    String type,
    User user,
    List<PlaylistSong> playlistSongs
  ) {
    this.playlistName = playlistName;
    this.spotifyPlaylistId = spotifyPlaylistId;
    this.timestamp = timestamp;
    this.longitude = longitude;
    this.latitude = latitude;
    this.seedTracks = seedTracks;
    this.targetAcousticness = targetAcousticness;
    this.targetDanceability = targetDanceability;
    this.targetEnergy = targetEnergy;
    this.targetInstrumentalness = targetInstrumentalness;
    this.targetKey = targetKey;
    this.targetLiveness = targetLiveness;
    this.targetLoudness = targetLoudness;
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
