package com.consent.service;

import com.consent.entity.Consent;
import com.consent.repo.ConsentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ConsentServiceImpl implements ConsentService{
    @Autowired
    private ConsentRepo consentRepo;


    @Override
    public String newConsent(String doctorId, String authToken, Consent consent) {
        return null;
    }

    @Override
    public ArrayList<Consent> allConsentsPatient(String patientId, String authToken) {
        return null;
    }

    @Override
    public ArrayList<Consent> allConsentsDoctor(String doctorId, String authToken) {
        return null;
    }

    @Override
    public String updateConsent(String patientId, String authToken, String requestId, Date startDate, Date endDate, Date validity) {
        return null;
    }

    @Override
    public String rejectConsent(String patientId, String authToken, String requestId) {
        return null;
    }
}
