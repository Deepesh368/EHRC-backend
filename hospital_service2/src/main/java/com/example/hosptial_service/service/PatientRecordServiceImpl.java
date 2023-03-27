package com.example.hosptial_service.service;

import java.util.Date;
import java.util.List;

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
    @Override
    public List<PatientRecord> findByPatientId(String id){
       return  patientRecordRepo.findByPatientId(id);
    }
    @Override
    public List<PatientRecord>findByDateOfVisitAndPatientId(Date d1,Date d2,String patient_id){
        return patientRecordRepo.findByDateOfVisitAndPatientId(d1,d2,patient_id);
    }
    
}
