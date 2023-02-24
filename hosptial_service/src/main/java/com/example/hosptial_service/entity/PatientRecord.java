package com.example.hosptial_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "patientrecord")
public class PatientRecord {
    @Id
    private String id;
    private String Patientid;
    private String Date_of_visit;
    private String RecordType; //(lab report, prescription, consultation etc);
    private String ReportDetails;
    
}
