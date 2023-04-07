package com.example.hosptial_service.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hosptial_service.entity.PatientRecord;

public interface PatientRecordRepo extends JpaRepository<PatientRecord,String> {
    public List<PatientRecord> findByPatientId(String patient_id);

    @Query(value = "SELECT * FROM patientrecord p WHERE p.patient_id = ?3 AND (p.date_of_visit BETWEEN ?1 AND ?2)",nativeQuery = true)
    public List<PatientRecord> findByDateOfVisitAndPatientId(Date startDate,Date endDate,String patient_id);    
    
}
