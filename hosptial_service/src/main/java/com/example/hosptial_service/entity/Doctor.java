package com.example.hosptial_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name  = "doctor")
public class Doctor {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String departmant;
    private String specialization;
    private String workinghours;
    private String authToken;
    
    
}
