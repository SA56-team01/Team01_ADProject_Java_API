package com.team1.backendApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team1.backendApi.model.Admin;
import com.team1.backendApi.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/auth")
    public ResponseEntity<String> checkAdminLogin(@RequestParam("admin_id") Long adminId, @RequestParam("password") String password) {

        Admin adminUser = adminService.getAdminById(adminId);

        if(adminUser == null) {
            String errorMessage = "Access denied.";
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorMessage);
        }

        if(!password.equals(adminUser.getPassword())) {
            String errorMessage = "Invalid credentials.";
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
        }

        return ResponseEntity.ok("Login successful.");
    }
}
