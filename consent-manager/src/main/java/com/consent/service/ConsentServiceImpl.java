package com.consent.service;

import com.consent.entity.Consent;
import com.consent.entity.Doctor;
import com.consent.entity.Patient;
import com.consent.repo.ConsentRepo;
import com.consent.repo.DoctorRepo;
import com.consent.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ConsentServiceImpl implements ConsentService{
    @Autowired
    private ConsentRepo consentRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;

    static String getRandom(int length)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    @Override
    public String newConsent(String doctorId, String authToken, Consent consent) {
        if(!doctorRepo.existsDoctorByUniqueID(doctorId)){
            return "doctor not found";
        }
        if(!patientRepo.existsPatientByUniqueID(consent.getPatientId())){
            return "patient not found";
        }
        if(!consent.getDoctorId().matches(doctorId)){
            return "invalid request";
        }
        // Authentication and autherization code here
        String random = getRandom(10);
        while(consentRepo.existsById(random)){
            random = getRandom(10);
        }
        consent.setRequestId(random);
        consentRepo.save(consent);
        return "Success";
    }

    @Override
    public ArrayList<Consent> allConsentsPatient(String patientId, String authToken) {
        if(!patientRepo.existsById(patientId)){
            return null;
        }
        // Authentication and autherization code here
        return consentRepo.findAllByPatientId(patientId);
    }

    @Override
    public ArrayList<Consent> allConsentsDoctor(String doctorId, String authToken) {
        if(!doctorRepo.existsDoctorByUniqueID(doctorId)){
            return null;
        }
        // Authentication and autherization code here
        return consentRepo.findAllByDoctorId(doctorId);
    }

    @Override
    public String updateConsent(String patientId, String authToken, String requestId, Date startDate, Date endDate, Date validity) {
        if(!patientRepo.existsById(patientId)){
            return "patient not found";
        }
        // Authentication and autherization code here
        Consent consent = consentRepo.findByRequestId(requestId);
        consent.setConsentValidity(validity);
        consent.setConsentStartDate(startDate);
        consent.setConsentEndDate(endDate);
        consent.setStatus("accepted");
        consentRepo.save(consent);
        return "success";
    }

    @Override
    public String rejectConsent(String patientId, String authToken, String requestId) {
        if(!patientRepo.existsById(patientId)){
            return "patient not found";
        }
        // Authentication and autherization code here
        Consent consent = consentRepo.findByRequestId(requestId);
        consent.setStatus("rejected");
        consentRepo.save(consent);
        return "success";

    }
}
