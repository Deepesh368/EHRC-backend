package com.consent.controller;

import com.consent.entity.Consent;
import com.consent.service.ConsentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

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
    public ResponseEntity<?> newRequestFromDoctor(@RequestHeader("auth-token") String authToken, @RequestParam("doctor_id") String docId, @RequestBody Consent consent){
        String res = consentService.newConsent(docId, authToken, consent);
        if(!res.matches("success")){
            return ResponseEntity.badRequest().body(convert(res));
        }
        return ResponseEntity.ok(convert(res));
    }

    @GetMapping("/get/patient")
    public ResponseEntity<?> getAllConsentsPatient(@RequestHeader("auth-token") String authToken, @RequestParam("patient_id") String patientId) {
        ArrayList<Consent> consents = consentService.allConsentsPatient(patientId,authToken);
        if(consents==null){
            return ResponseEntity.badRequest().body("invalid request");
        }
        return ResponseEntity.ok(consents);
    }
}
