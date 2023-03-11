package com.example.hosptial_service.service;

import com.example.hosptial_service.entity.Doctor;

public interface DoctorService {
    String newUser(Doctor user);
    // String login(String email, String password);
    // String logout(String email);
    void deleteUser(String email);
    // void updateUserDetails(String userId, Doctor user);
    // void changePassword(String email, String currPass, String newPass);
    
}
