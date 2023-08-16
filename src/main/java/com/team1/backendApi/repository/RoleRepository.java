package com.team1.backendApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.backendApi.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}

