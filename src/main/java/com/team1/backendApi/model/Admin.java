package com.team1.backendApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "admin_id")
  private Long id;

  private String username;

  private String password;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "role_id")
  private Role role;

  public Admin(String username, String password, Role role) {
    this.username = username;
    this.password = password;
    this.role = role;
  }
}
