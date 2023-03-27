package com.example.hosptial_service.service;

import com.example.hosptial_service.entity.Doctor;
import com.example.hosptial_service.entity.PatientRecord;
import com.example.hosptial_service.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    public String SaveUser(Doctor user) {
        doctorRepo.save(user);
        return "saved";
    }

}
