package com.example.hospital_manager.repo;

import com.example.hospital_manager.entity.HospitalAddr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalAddrRepo extends JpaRepository<HospitalAddr,Integer> {
}
