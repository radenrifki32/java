package com.example.phonebook.controller;

import com.example.phonebook.ApiResponse;
import com.example.phonebook.dto.RegisterResponse;
import com.example.phonebook.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.phonebook.model.AppUser;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody AppUser user) {
        try {
            System.out.println();
            authService.register(user);
            RegisterResponse registerResponse = RegisterResponse.builder()
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .build();
            ApiResponse response = new ApiResponse("User Berhasil Disimpan", true, registerResponse);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            ApiResponse response = new ApiResponse(e.getMessage(), false, null);
            return ResponseEntity.badRequest().body(response);
        } catch (IllegalStateException e) {
            ApiResponse response = new ApiResponse(e.getMessage(), false, null);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }
//    @PostMapping("/login")
//    public ResponseEntity<ApiResponse>login(@RequestBody AppUser user) {
//        try {
//            authService.login(user.getEmail(), user.getPassword());
//            return ResponseEntity.ok(new ApiResponse("Login Success", true, null));
//        }catch (Exception e) {
//            ApiResponse response = new ApiResponse(e.getMessage(), false, null);
//            return ResponseEntity.badRequest().body(response);
//        }
//    }
}
