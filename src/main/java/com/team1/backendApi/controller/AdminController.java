package com.team1.backendApi.controller;

import com.team1.backendApi.model.Admin;
import com.team1.backendApi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

  @Autowired
  AdminService adminService;

  @GetMapping("/auth")
  public ResponseEntity<String> checkAdminLogin(
    @RequestParam("username") String username,
    @RequestParam("password") String password
  ) {
    Admin adminUser = adminService.getAdminByUsername(username);

    if (adminUser == null) {
      String errorMessage = "{\"message\": \"Access denied.\"}";
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorMessage);
    }

    if (!password.equals(adminUser.getPassword())) {
      String errorMessage = "{\"message\": \"Invalid credentials.\"}";
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
    }

    return ResponseEntity.ok("{\"message\": \"Login successful.\"}");
  }
}
