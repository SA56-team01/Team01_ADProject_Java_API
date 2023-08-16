package com.team1.backendApi.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDto {

  private Long id;
  private String playlistName;
  private String spotifyPlaylistId;
  private String timestamp;
  private Double longitude;
  private Double latitude;
  private String seedTracks;
  private double targetAcousticness;
  private double targetDanceability;
  private double targetEnergy;
  private double targetInstrumentalness;
  private double targetKey;
  private double targetLiveness;
  private double targetLoudness;
  private double targetMode;
  private double targetSpeechiness;
  private double targetTempo;
  private double targetTimeSignature;
  private double targetValence;
  private String type;

  private List<PlaylistSong> playlistSongs;
}
