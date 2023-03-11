package com.example.hosptial_service.entity;

import java.util.Date;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name  = "consentedpatientrecord")
public class ConsentedPatientRecord {
    @Id
    private String id;
    private String patientId;
    private String hospitalId;
    private String recordType; //(lab report, prescription, consultation etc);
    private String reportDetails;
    private int severity; 

    @Temporal(TemporalType.DATE)
    private Date dateOfVisit;

    @Temporal(TemporalType.DATE)
    private Date consentExpDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = true)
    @OnDelete(action =OnDeleteAction.CASCADE)
    private Doctor doctor;
}
