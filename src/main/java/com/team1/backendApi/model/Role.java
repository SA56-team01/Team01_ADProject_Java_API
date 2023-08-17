// package com.team1.backendApi.model;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;

// @Getter
// @Setter
// @Entity
// @Table(name = "role")
// public class Role {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String roleType;

//     @OneToOne(mappedBy = "role")
//     private Admin admin;

//     public Role() {
//         // Default constructor required by JPA
//     }

//     public Role(String roleType) {
//         this.roleType = roleType;
//     }
// }