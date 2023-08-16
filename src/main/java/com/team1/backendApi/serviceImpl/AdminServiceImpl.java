package com.team1.backendApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team1.backendApi.model.Admin;
import com.team1.backendApi.repository.AdminRepository;
import com.team1.backendApi.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
    
    @Autowired
    AdminRepository adminRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Admin saveAdmin(Admin admin) {
        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(hashedPassword);

        return adminRepo.save(admin);
    }

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