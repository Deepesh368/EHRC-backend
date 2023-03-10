package com.example.hosptial_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name  = "doctor")
public class Doctor {
    @Id
    private String id;
    private String name;
    private String departmant;
    private String position;
    private String specialization;

}
