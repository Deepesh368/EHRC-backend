package com.consent.service;

import com.consent.entity.Consent;
import com.consent.entity.User;
import com.consent.repo.ConsentRepo;
import com.consent.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ConsentServiceImpl implements ConsentService{
    @Autowired
    private ConsentRepo consentRepo;

    @Autowired
    private UserRepo userRepo;


    @Override
    public String newConsent(String doctorId, String authToken, Consent consent) {
        User user = userRepo.findByUniqueIDIgnoreCase(doctorId);
        if(!user.getUserType().matches("doctor")){
            return "Not a Doctor";
        }

        if(user.getAuthToken().matches(authToken)){
            // Generate consent ID
            consent.setRequestId("1234");
            consentRepo.save(consent);
            return "Success";
        }
        return "Incorrect Login";
    }

    @Override
    public ArrayList<Consent> allConsentsPatient(String patientId, String authToken) {
        User user = userRepo.findByUniqueIDIgnoreCase(patientId);
        if(!user.getUserType().matches("patient")){
            return null;
        }

        if(user.getAuthToken().matches(authToken)){
            // Generate consent ID
            return consentRepo.findAllByPatientId(patientId);
        }
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
