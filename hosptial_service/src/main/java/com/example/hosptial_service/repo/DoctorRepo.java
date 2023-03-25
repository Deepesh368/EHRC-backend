package com.example.hosptial_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hosptial_service.entity.Doctor;

import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,String> {
    Optional<Doctor> findByEmail(String email);
}
