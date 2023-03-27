package com.consent.controller;

import com.consent.entity.Consent;
import com.consent.service.ConsentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consent")
public class ConsentController {
    @Autowired
    private ConsentService consentService;

    private HashMap<String, String> convert(String res) {
        HashMap<String, String> map = new HashMap<>();
        map.put("response", res);
        return map;
    }

    @PostMapping("/doctor/create")
    public ResponseEntity<?> newRequestFromDoctor(@RequestBody Consent consent){
        String res = consentService.newConsent(consent);
        if(!res.matches("Success")){
            return ResponseEntity.badRequest().body(convert(res));
        }
        return ResponseEntity.ok(convert(res));
    }

    @GetMapping("/get/doctor")
    public ResponseEntity<?> getAllConsentsDoctor(@RequestParam("doctor_id") Integer doctorId, @RequestParam("hospital_id") String hospitalId) {
        ArrayList<Consent> consents = consentService.allConsentsDoctor(doctorId, hospitalId);
        if(consents==null){
            return ResponseEntity.badRequest().body("No consent requested by the doctor");
        }
        return ResponseEntity.ok(consents);
    }

    @GetMapping("/get/patient")
    public ResponseEntity<?> getAllConsentsPatient(@RequestParam("patient_id") String patientId) {
        ArrayList<Consent> consents = consentService.allConsentsPatient(patientId);
        if(consents==null){
            return ResponseEntity.badRequest().body("No consent requested for the patient");
        }
        return ResponseEntity.ok(consents);
    }

    @PutMapping("/update/patient")
    public ResponseEntity<?> updateConsent(@RequestParam("consent_id") String consent_id, @RequestBody Map<String, String> payload){
        if(payload.get("status").matches("reject")){
            consentService.rejectConsent(consent_id);
            return ResponseEntity.ok(convert("changes made successfully"));
        }
        consentService.updateConsent(consent_id, payload.get("startDate"), payload.get("endDate"), payload.get("validity"));
        return ResponseEntity.ok(convert("changes made successfully"));
    }

    @GetMapping("/get_consent")
    public ResponseEntity<?> getConsent(@RequestParam("consent_id") String consent_id){
        Consent consent = consentService.getConsent(consent_id);
        if(consent==null){
            return ResponseEntity.ok(convert("invalid consent id"));
        }
        return ResponseEntity.ok(consent);
    }
}
