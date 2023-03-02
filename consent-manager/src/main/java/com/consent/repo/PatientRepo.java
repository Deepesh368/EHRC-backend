package com.consent.repo;

import com.consent.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, String> {
    public Patient findByEmailIgnoreCase(String email);
    public Patient findByUniqueID(String id);
    public boolean existsPatientByUniqueID(String id);

}
