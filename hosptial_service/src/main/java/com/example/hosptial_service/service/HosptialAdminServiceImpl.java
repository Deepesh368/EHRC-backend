package com.example.hosptial_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hosptial_service.entity.Doctor;
import com.example.hosptial_service.entity.HospitalAdmin;
import com.example.hosptial_service.repo.DoctorRepo;
import com.example.hosptial_service.repo.HospitalAdminRepo;

@Service
public class HosptialAdminServiceImpl implements HospitalAdminService {
    @Autowired
    private HospitalAdminRepo hospitalAdminRepo;
    @Autowired
    private DoctorRepo doctorRepo;
    static String getAlphaNumericString()
    {
        int n = 32;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz" + "!@#$%^&*()";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
    @Override
    public String newUser(HospitalAdmin user) {
        hospitalAdminRepo.save(user);
        return "saved";
    }
    @Override
    public String AddDoctor(Doctor d){
        doctorRepo.save(d);
        return "saved";
    }

    @Override
    public String login(String email, String password) {
        HospitalAdmin user = hospitalAdminRepo.findByEmailIgnoreCase(email);
        if(user == null) return "not-found";
        if(!user.getPassword().equals(password)){
            return "incorrect-password";
        }
        return user.getAuthToken();
    }
    @Override
    public String logout(String email) {
        HospitalAdmin user = hospitalAdminRepo.findByEmailIgnoreCase(email);
        if(user== null) return "not-found";
        String random = getAlphaNumericString();
        user.setAuthToken(random);
        hospitalAdminRepo.save(user);
        return "success";
    }
    @Override
    public void deleteUser(String email) {  
        return;
    }

    @Override
    public void updateUserDetails(String userId, HospitalAdmin user) {
    }

    
}
