package com.consent.service;

import com.consent.entity.Consent;

import java.util.ArrayList;
import java.util.Date;

public interface ConsentService {
    String newConsent(String doctorId, String authToken, Consent consent);
    ArrayList<Consent> allConsentsPatient(String patientId, String authToken);
    ArrayList<Consent> allConsentsDoctor(String doctorId, String authToken);

    String updateConsent(String patientId, String authToken, String requestId, Date startDate, Date endDate, Date validity);
    String rejectConsent(String patientId, String authToken, String requestId);
}
