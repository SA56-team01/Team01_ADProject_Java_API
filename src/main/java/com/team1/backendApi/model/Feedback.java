package com.team1.backendApi.model;

import javax.persistence.*;
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

    public Feedback(){}

    public Feedback(Long id, String feedbackText, String fbTimestamp, User user) {
        this.id = id;
        this.feedbackText = feedbackText;
        this.fbTimestamp = fbTimestamp;
        this.user = user;
    }
}
