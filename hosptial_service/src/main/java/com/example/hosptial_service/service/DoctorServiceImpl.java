package com.example.hosptial_service.service;

import java.util.Optional;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hosptial_service.entity.Doctor;
import com.example.hosptial_service.repo.DoctorRepo;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    // static String getAlphaNumericString()
    // {
    //     int n = 32;
    //     String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    //             + "0123456789"
    //             + "abcdefghijklmnopqrstuvxyz" + "!@#$%^&*()";
    //     StringBuilder sb = new StringBuilder(n);
    //     for (int i = 0; i < n; i++) {
    //         int index
    //                 = (int)(AlphaNumericString.length()
    //                 * Math.random());
    //         sb.append(AlphaNumericString
    //                 .charAt(index));
    //     }

    //     return sb.toString();
    // }
    @Override
    public String newUser(Doctor user) {
        doctorRepo.save(user);
        return "saved";
    }
    @Override
    public Doctor findById(String id){
         return doctorRepo.findById(id).get();

    }
    // public String login(String email, String password) {

    //     Doctor user = doctorRepo.findByEmailIgnoreCase(email);
    //     if(user == null) return "not-found";
    //     if(!user.getPassword().equals(password)){
    //         return "incorrect-password";
    //     }
    //     return user.getAuthToken();
    // }
    // @Override
    // public String logout(String email) {
    //     Doctor user = doctorRepo.findByEmailIgnoreCase(email);
    //     if(user== null) return "not-found";
    //     String random = getAlphaNumericString();
    //     user.setAuthToken(random);
    //     doctorRepo.save(user);
    //     return "success";
    // }
    @Override
    public void deleteUser(String email) {  
        return;

    }

    // @Override
    // public void updateUserDetails(String userId, Doctor user) {

    // }

    // @Override
    // public void changePassword(String email, String currPass, String newPass) {

    // }







    
}
