package com.team1.backendApi.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table (name="feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="feedback_id")
    private Long id;

    @Column(name="feedback_text")
    private String feedbackText;

    @Column(name="fb_timestamp")
    private String fbTimestamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Transient // to indicate a non-persistent field
    private String spotifyUserId; // for mapping the Spotify user ID
}