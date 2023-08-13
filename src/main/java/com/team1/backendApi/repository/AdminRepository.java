package com.team1.backendApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.backendApi.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findById(Long adminId);
    
}
