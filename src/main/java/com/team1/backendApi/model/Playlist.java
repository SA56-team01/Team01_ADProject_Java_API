package com.team1.backendApi.model;

import javax.persistence.*;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @Column(name = "timestamp_created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate timestampCreated;

    @Column(name = "ms_played")
    private int msPlayed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Playlist() {
        // Default constructor required by JPA
    }

    public Playlist(LocalDate timestampCreated, int msPlayed, User user) {
        this.timestampCreated = timestampCreated;
        this.msPlayed = msPlayed;
        this.user = user;
    }

}