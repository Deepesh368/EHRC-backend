package com.example.hosptial_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hosptial_service.entity.PatientRecord;
import com.example.hosptial_service.repo.PatientRecordRepo;
@Service
public class PatientRecordServiceImpl implements PatientRecordService {
    @Autowired
    private PatientRecordRepo patientRecordRepo;
    @Override
    public String newUser(PatientRecord user) {
        patientRecordRepo.save(user);
        return "saved";
    }

    
}
