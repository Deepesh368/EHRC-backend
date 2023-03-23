package com.consent.service;

import com.consent.entity.Consent;
import com.consent.repo.ConsentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Service
public class ConsentServiceImpl implements ConsentService{
    @Autowired
    private ConsentRepo consentRepo;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime now = LocalDateTime.now();

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
    public String newConsent(Consent consent) {
        String random = getRandom(10);
        while(consentRepo.existsById(random)){
            random = getRandom(10);
        }
        consent.setRequestId(random);
        if(consent.getStatus()==null || !consent.getStatus().matches("Emergency")) {
            consent.setStatus("Pending");
        }
        consent.setConsentEndDate(null);
        consent.setConsentStartDate(null);
        consent.setConsentValidity(null);
        consent.setDateOfRequest(dtf.format(now));
//        consent.setDateOfRequest("");
        consentRepo.save(consent);
        return "Success";
    }

    @Override
    public ArrayList<Consent> allConsentsPatient(String patientId) {
        return consentRepo.findAllByPatientId(patientId);
    }

    @Override
    public ArrayList<Consent> allConsentsDoctor(String doctorId) {
        return consentRepo.findAllByDoctorId(doctorId);
    }

    @Override
    public String updateConsent(String requestId, String startDate, String endDate, String validity) {
        Consent consent = consentRepo.findByRequestId(requestId);
        if(consent==null) return "invalid consent id";
        consent.setConsentValidity(validity);
        consent.setConsentStartDate(startDate);
        consent.setConsentEndDate(endDate);
        consent.setStatus("accepted");
        consentRepo.save(consent);
        return "success";
    }

    @Override
    public String rejectConsent(String requestId) {
        Consent consent = consentRepo.findByRequestId(requestId);
        if(consent==null) return "invalid consent id";
        consent.setStatus("rejected");
        consentRepo.save(consent);
        return "success";
    }

    @Override
    public Consent getConsent(String consentId) {
        return consentRepo.findByRequestId(consentId);
    }
}
