package com.team1.backendApi.service;

import com.team1.backendApi.model.Admin;

public interface AdminService {

    Admin getAdminById(Long adminId);
    Admin getAdminByUsername(String username);
    Admin saveAdmin(Admin admin);
}
