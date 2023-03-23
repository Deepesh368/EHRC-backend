package com.doctors.Repo;

import com.doctors.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, String> {
    public Doctor findByEmailIgnoreCase(String email);
}
