package com.team1.backendApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long userId;

  @Column(
    name = "spotify_user_id",
    nullable = false,
    columnDefinition = "varchar(223)"
  )
  private String spotifyUserId;

  @Column(name = "user_market")
  private String userMarket;

  @Column(name = "user_email")
  private String userEmail;

  @OneToMany(
    cascade = { CascadeType.PERSIST, CascadeType.MERGE },
    mappedBy = "user"
  )
  @JsonIgnore
  private List<Playlist> playlists;

  @OneToMany(
    cascade = { CascadeType.PERSIST, CascadeType.MERGE },
    mappedBy = "user"
  )
  @JsonIgnore
  private List<UserHistory> userHistories;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  @JsonIgnore
  private List<Feedback> feedback;

  public User(String spotifyUserId, String userMarket, String userEmail) {
    this.spotifyUserId = spotifyUserId;
    this.userMarket = userMarket;
    this.userEmail = userEmail;
    this.playlists = new ArrayList<Playlist>();
    this.userHistories = new ArrayList<UserHistory>();
    this.feedback = new ArrayList<Feedback>();
  }

  public User(String spotifyUserId, String userEmail) {
    this.spotifyUserId = spotifyUserId;
    this.userMarket = "SG";
    this.userEmail = userEmail;
  }
}
