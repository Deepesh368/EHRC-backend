package com.example.hosptial_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name  = "Doctors")
public class Doctor {
    @Id
    private String uniqueID;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String departmant;
    private String specialization;
    private String workinghours;
    
    
}
