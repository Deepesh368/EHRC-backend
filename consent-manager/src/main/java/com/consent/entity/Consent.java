package com.consent.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "consent")
public class Consent {
    @Id
    private String requestId;
    private Integer doctorId;
    private String patientId;
    private String requestingHospitalId;
    private String sendingHospitalId;
    private String status;
    private Date dateOfRequest;
    private Date reqStartDate;
    private Date reqEndDate;
    private Date reqValidity;
    private Date consentStartDate;
    private Date consentEndDate;
    private Date consentValidity;

    public Consent() {
    }

    public Consent(Integer doctorId, String patientId, String requestingHospitalId, String sendingHospitalId,Date reqStartDate,Date reqEndDate,Date reqValidity) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.sendingHospitalId = sendingHospitalId;
        this.reqStartDate = reqStartDate;
        this.reqEndDate = reqEndDate;
        this.reqValidity = reqValidity;
        this.requestingHospitalId = requestingHospitalId;
    }

    public Consent(Integer doctorId, String patientId,String requestingHospitalId, String sendingHospitalId, String status, Date reqStartDate,Date reqEndDate,Date reqValidity) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.requestingHospitalId = requestingHospitalId;
        this.sendingHospitalId = sendingHospitalId;
        this.status = status;
        this.reqStartDate = reqStartDate;
        this.reqEndDate = reqEndDate;
        this.reqValidity = reqValidity;
    }
}
