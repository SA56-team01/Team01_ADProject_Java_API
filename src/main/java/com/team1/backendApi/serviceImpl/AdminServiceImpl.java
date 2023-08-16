package com.team1.backendApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team1.backendApi.model.Admin;
import com.team1.backendApi.repository.AdminRepository;
import com.team1.backendApi.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
    
    @Autowired
    AdminRepository adminRepo;

    @Override
    public Admin getAdminById(Long adminId) {

        Admin adminUser = adminRepo.findById(adminId).orElse(null);

        if (adminUser != null) {
            return adminUser;
        }

        return null;

    }
    @Override
    public Admin getAdminByUsername(String username) {
        return adminRepo.findByUsername(username);
    }
    
}