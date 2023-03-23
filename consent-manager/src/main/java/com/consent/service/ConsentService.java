package com.consent.service;

import com.consent.entity.Consent;

import java.util.ArrayList;

public interface ConsentService {
    String newConsent(Consent consent);
    ArrayList<Consent> allConsentsPatient(String patientId);
    ArrayList<Consent> allConsentsDoctor(String doctorId);
    String updateConsent(String consentId, String startDate, String endDate, String validity);
    String rejectConsent(String consentId);

    Consent getConsent(String consentId);
}
