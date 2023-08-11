package com.team1.backendApi.model;//package com.team1.backendApi.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name="songs")
//public class Song {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="song_id")
//    private String songId;
//
//    @Column(name= "spotify_track_id")
//    private String spotifyTrackId;
//    @Column(name= "acousticness")
//    private Double acousticness;
//    @Column(name= "analysis_url")
//    private String analysisUrl;
//    @Column(name= "danceability")
//    private Double danceability;
//    @Column(name= "duration_ms", columnDefinition = "INTEGER")
//    private Integer durationMs;
//    @Column(name= "energy")
//    private Double energy;
//    @Column(name= "instrumentalness")
//    private Double instrumentalness;
//    @Column(name= "key", columnDefinition = "INTEGER")
//    private Integer key;
//    @Column(name= "liveness")
//    private Double liveness;
//    @Column(name= "loudness")
//    private Double loudness;
//    @Column(name= "mode", columnDefinition = "INTEGER")
//    private Integer mode;
//    @Column(name= "speechiness")
//    private Double speechiness;
//    @Column(name= "tempo")
//    private Double tempo;
//    @Column(name= "time_signature", columnDefinition = "INTEGER")
//    private Integer timeSignature;
//    @Column(name= "track_href")
//    private String trackHref;
//    @Column(name= "type")
//    private String type;
//    @Column(name= "uri")
//    private String uri;
//    @Column(name= "valence")
//    private Double valence;
//    public Song(){}
//
//    public Song(String spotifyTrackId, Double acousticness, String analysisUrl, Double danceability, Integer durationMs, Double energy, Double instrumentalness, Integer key, Double liveness, Double loudness, Integer mode, Double speechiness, Double tempo, Integer timeSignature, String trackHref, String type, String uri, Double valence) {
//        this.spotifyTrackId = spotifyTrackId;
//        this.acousticness = acousticness;
//        this.analysisUrl = analysisUrl;
//        this.danceability = danceability;
//        this.durationMs = durationMs;
//        this.energy = energy;
//        this.instrumentalness = instrumentalness;
//        this.key = key;
//        this.liveness = liveness;
//        this.loudness = loudness;
//        this.mode = mode;
//        this.speechiness = speechiness;
//        this.tempo = tempo;
//        this.timeSignature = timeSignature;
//        this.trackHref = trackHref;
//        this.type = type;
//        this.uri = uri;
//        this.valence = valence;
//    }
//
//    public String getSongId() {
//        return songId;
//    }
//
//    public void setSongId(String songId) {
//        this.songId = songId;
//    }
//
//    public String getSpotifyTrackId() {
//        return spotifyTrackId;
//    }
//
//    public void setSpotifyTrackId(String spotifyTrackId) {
//        this.spotifyTrackId = spotifyTrackId;
//    }
//
//    public Double getAcousticness() {
//        return acousticness;
//    }
//
//    public void setAcousticness(Double acousticness) {
//        this.acousticness = acousticness;
//    }
//
//    public String getAnalysisUrl() {
//        return analysisUrl;
//    }
//
//    public void setAnalysisUrl(String analysisUrl) {
//        this.analysisUrl = analysisUrl;
//    }
//
//    public Double getDanceability() {
//        return danceability;
//    }
//
//    public void setDanceability(Double danceability) {
//        this.danceability = danceability;
//    }
//
//    public Integer getDurationMs() {
//        return durationMs;
//    }
//
//    public void setDurationMs(Integer durationMs) {
//        this.durationMs = durationMs;
//    }
//
//    public Double getEnergy() {
//        return energy;
//    }
//
//    public void setEnergy(Double energy) {
//        this.energy = energy;
//    }
//
//    public Double getInstrumentalness() {
//        return instrumentalness;
//    }
//
//    public void setInstrumentalness(Double instrumentalness) {
//        this.instrumentalness = instrumentalness;
//    }
//
//    public Integer getKey() {
//        return key;
//    }
//
//    public void setKey(Integer key) {
//        this.key = key;
//    }
//
//    public Double getLiveness() {
//        return liveness;
//    }
//
//    public void setLiveness(Double liveness) {
//        this.liveness = liveness;
//    }
//
//    public Double getLoudness() {
//        return loudness;
//    }
//
//    public void setLoudness(Double loudness) {
//        this.loudness = loudness;
//    }
//
//    public Integer getMode() {
//        return mode;
//    }
//
//    public void setMode(Integer mode) {
//        this.mode = mode;
//    }
//
//    public Double getSpeechiness() {
//        return speechiness;
//    }
//
//    public void setSpeechiness(Double speechiness) {
//        this.speechiness = speechiness;
//    }
//
//    public Double getTempo() {
//        return tempo;
//    }
//
//    public void setTempo(Double tempo) {
//        this.tempo = tempo;
//    }
//
//    public Integer getTimeSignature() {
//        return timeSignature;
//    }
//
//    public void setTimeSignature(Integer timeSignature) {
//        this.timeSignature = timeSignature;
//    }
//
//    public String getTrackHref() {
//        return trackHref;
//    }
//
//    public void setTrackHref(String trackHref) {
//        this.trackHref = trackHref;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getUri() {
//        return uri;
//    }
//
//    public void setUri(String uri) {
//        this.uri = uri;
//    }
//
//    public Double getValence() {
//        return valence;
//    }
//
//    public void setValence(Double valence) {
//        this.valence = valence;
//    }
//
//    @Override
//    public String toString() {
//        return "Song{" +
//                "songId='" + songId + '\'' +
//                ", spotifyTrackId='" + spotifyTrackId + '\'' +
//                ", acousticness=" + acousticness +
//                ", analysisUrl='" + analysisUrl + '\'' +
//                ", danceability=" + danceability +
//                ", durationMs=" + durationMs +
//                ", energy=" + energy +
//                ", instrumentalness=" + instrumentalness +
//                ", key=" + key +
//                ", liveness=" + liveness +
//                ", loudness=" + loudness +
//                ", mode=" + mode +
//                ", speechiness=" + speechiness +
//                ", tempo=" + tempo +
//                ", timeSignature=" + timeSignature +
//                ", trackHref='" + trackHref + '\'' +
//                ", type='" + type + '\'' +
//                ", uri='" + uri + '\'' +
//                ", valence=" + valence +
//                '}';
//    }
//}

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private String songId;

    @Column(name = "spotify_track_id")
    private String spotifyTrackId;

    // Double attributes commented out
    /*@Column(name = "acousticness")
    private Double acousticness;
    @Column(name = "danceability")
    private Double danceability;
    @Column(name = "energy")
    private Double energy;
    @Column(name = "instrumentalness")
    private Double instrumentalness;
    @Column(name = "liveness")
    private Double liveness;
    @Column(name = "loudness")
    private Double loudness;
    @Column(name = "speechiness")
    private Double speechiness;
    @Column(name = "tempo")
    private Double tempo;
    @Column(name = "valence")
    private Double valence;*/

    @Column(name = "analysis_url")
    private String analysisUrl;

    @Column(name = "duration_ms", columnDefinition = "INTEGER")
    private Integer durationMs;

    @Column(name = "key", columnDefinition = "INTEGER")
    private Integer key;

    @Column(name = "mode", columnDefinition = "INTEGER")
    private Integer mode;

    @Column(name = "time_signature", columnDefinition = "INTEGER")
    private Integer timeSignature;

    @Column(name = "track_href")
    private String trackHref;

    @Column(name = "type")
    private String type;

    @Column(name = "uri")
    private String uri;

    // Constructor without Double attributes
    public Song(String spotifyTrackId, String analysisUrl, Integer durationMs, Integer key, Integer mode, Integer timeSignature, String trackHref, String type, String uri) {
        this.spotifyTrackId = spotifyTrackId;
        this.analysisUrl = analysisUrl;
        this.durationMs = durationMs;
        this.key = key;
        this.mode = mode;
        this.timeSignature = timeSignature;
        this.trackHref = trackHref;
        this.type = type;
        this.uri = uri;
    }

    // Getters and Setters

    @Override
    public String toString() {
        return "Song{" +
                "songId='" + songId + '\'' +
                ", spotifyTrackId='" + spotifyTrackId + '\'' +
                '}';
    }
}
