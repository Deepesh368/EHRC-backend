package com.consent.repo;

import com.consent.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, String> {
    public Doctor findByEmailIgnoreCase(String email);
    public Doctor findByUniqueID(String id);
    public boolean existsDoctorByUniqueID(String id);

}
