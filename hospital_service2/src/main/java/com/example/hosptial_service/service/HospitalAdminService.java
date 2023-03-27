package com.example.hosptial_service.service;
import com.example.hosptial_service.entity.Doctor;
import com.example.hosptial_service.entity.HospitalAdmin;
public interface HospitalAdminService {
    String newUser(HospitalAdmin user);
    String login(String email, String password);
    String logout(String email);
    String AddDoctor(Doctor d);
    void deleteUser(String email);
    void updateUserDetails(String userId, HospitalAdmin user);
    
    
}
