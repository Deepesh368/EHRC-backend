package com.example.hosptial_service.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hosptial_service.entity.ConsentedPatientRecord;

@Repository
public interface ConsentedPatientRecordRepo extends JpaRepository<ConsentedPatientRecord,String> {
    public List<ConsentedPatientRecord> findByUprnId(String uprn_id);

    
}
