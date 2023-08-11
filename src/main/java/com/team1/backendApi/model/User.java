package com.team1.backendApi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name = "spotify_userId", nullable = false)
    private String spotifyUserId;

    @Column(name = "user_market")
    private String userMarket;

    @Column(name = "user_email")
    private String userEmail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Playlist> playlists;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserHistory> userHistories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Feedback> feedback;


    public User() {
        // Default constructor required by JPA
    }

    public User(String spotifyUserId, String userMarket, String userEmail, Role role) {
        this.spotifyUserId = spotifyUserId;
        this.userMarket = userMarket;
        this.userEmail = userEmail;
        this.role = role;
        this.playlists = new ArrayList<Playlist>();
        this.userHistories = new ArrayList<UserHistory>();
        this.feedback = new ArrayList<Feedback>();
    }
}