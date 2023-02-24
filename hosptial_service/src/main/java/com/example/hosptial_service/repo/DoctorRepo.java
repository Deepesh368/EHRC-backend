package com.example.hosptial_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hosptial_service.entity.Doctor;
@Repository
public interface DoctorRepo extends JpaRepository<Doctor,String> {
    public Doctor findByEmailIgnoreCase(String email);
    public Doctor findByPhoneIgnoreCase(String phone);
}
