package com.example.hosptial_service.service;

import java.util.List;

import com.example.hosptial_service.entity.ConsentedPatientRecord;

public interface ConsentedPatientRecordService {
    String save(ConsentedPatientRecord c);
    List<ConsentedPatientRecord> findByUprnId(String id);
    


    
}
