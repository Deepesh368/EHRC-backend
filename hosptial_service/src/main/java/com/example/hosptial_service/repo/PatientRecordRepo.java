package com.example.hosptial_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hosptial_service.entity.PatientRecord;

public interface PatientRecordRepo extends JpaRepository<PatientRecord,String> {
    
    
}
