package com.example.hosptial_service.entity;

import java.sql.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConsentedPatientRecord {
    @Id
    private int id;
    private String patient_id;
    private String hospital_id;
    private String RecordType; //(lab report, prescription, consultation etc);
    private String ReportDetails;
    private int severity; 
    private Date Date_of_visit;
    private Date ConsentExpDate;
    @ManyToOne
    @JoinColumn(name = "uprn_id",nullable = false)
    @OnDelete(action =OnDeleteAction.CASCADE)
    private Doctor doctor;
}
