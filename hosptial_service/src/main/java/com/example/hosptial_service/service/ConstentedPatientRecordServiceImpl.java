package com.example.hosptial_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hosptial_service.entity.ConsentedPatientRecord;
import com.example.hosptial_service.repo.ConsentedPatientRecordRepo;

@Service
public class ConstentedPatientRecordServiceImpl implements ConsentedPatientRecordService {
    @Autowired
    private ConsentedPatientRecordRepo crepo;
    @Override
    public String save(ConsentedPatientRecord c){
        crepo.save(c);
        return "Success";
    }

    @Override
    public List<ConsentedPatientRecord> findByUprnId(String id){
        return crepo.findByUprnId(id);
    }


    
}
