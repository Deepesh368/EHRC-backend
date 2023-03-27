package com.example.hosptial_service.payloads;

import java.util.Date;

import jakarta.persistence.Id;

public class Consent {
    @Id
    private String requestId;
    private String doctorId;
    private String patientId;
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

    public Consent(String doctorId, String patientId, String sendingHospitalId, Date reqStartDate, Date reqEndDate, Date reqValidity) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.sendingHospitalId = sendingHospitalId;
        this.reqStartDate = reqStartDate;
        this.reqEndDate = reqEndDate;
        this.reqValidity = reqValidity;
    }

    public Consent(String doctorId, String patientId, String sendingHospitalId, String status, Date reqStartDate, Date reqEndDate, Date reqValidity) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.sendingHospitalId = sendingHospitalId;
        this.status = status;
        this.reqStartDate = reqStartDate;
        this.reqEndDate = reqEndDate;
        this.reqValidity = reqValidity;
    }
}
