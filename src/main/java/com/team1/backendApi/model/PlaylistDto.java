package com.team1.backendApi.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistDto {

    private Long id;

    private String playlistName;
    private String timestampCreated;
    private double longitudeCreated;

    private double latitudeCreated;

    private String seedTracks;

    private double targetAcousticness;

    private double targetDanceability;

    private double targetEnergy;

    private double targetInstrumentalness;

    private double targetKey;

    private double targetLiveness;

    private double targetLoudenes;

    private double targetMode;

    private double targetSpeechiness;

    private double targetTempo;

    private double targetTimeSignature;

    private double targetValence;

    private String type;

    //private List<Long> trackIds;

    private List<PlaylistSongDto> playlistSongs;

    public void setPlaylistSongs(List<PlaylistSongDto> playlistSongs) {
        this.playlistSongs = playlistSongs;
    }

    public PlaylistDto() {}

    public PlaylistDto(Playlist playlist, List<Long> trackIds) {
        this.id = playlist.getId();
        this.playlistName = playlist.getPlaylistName();
        this.timestampCreated = playlist.getTimestampCreated();
        this.longitudeCreated = playlist.getLongitudeCreated();
        this.latitudeCreated = playlist.getLatitudeCreated();
        this.seedTracks = playlist.getSeedTracks();
        this.targetAcousticness = playlist.getTargetAcousticness();
        this.targetDanceability = playlist.getTargetDanceability();
        this.targetEnergy = playlist.getTargetEnergy();
        this.targetInstrumentalness = playlist.getTargetInstrumentalness();
        this.targetKey = playlist.getTargetKey();
        this.targetLiveness = playlist.getTargetLiveness();
        this.targetLoudenes = playlist.getTargetLoudenes();
        this.targetMode = playlist.getTargetMode();
        this.targetSpeechiness = playlist.getTargetSpeechiness();
        this.targetTempo = playlist.getTargetTempo();
        this.targetTimeSignature = playlist.getTargetTimeSignature();
        this.targetValence = playlist.getTargetValence();
        this.type = playlist.getType();
        //this.trackIds = trackIds;
    }

}
