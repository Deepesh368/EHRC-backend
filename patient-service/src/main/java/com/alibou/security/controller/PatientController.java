package com.alibou.security.controller;

import com.alibou.security.entity.Consent;
import com.alibou.security.entity.Patient;
import com.alibou.security.entity.PatientRecord;
import com.alibou.security.repository.PatientRepository;
import com.alibou.security.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

  private String consentServer = "http://localhost:9002/consent/";
  private String hospitalManager = "http://localhost:9001/";
  @Autowired
  private PatientService patientService;

  @Autowired
  private WebClient webClient;
  @GetMapping("/get-details")
  public ResponseEntity<?>hello(@AuthenticationPrincipal Patient patient) {
    return ResponseEntity.accepted().body(patient);
  }
  @GetMapping("/all-consents")
  ResponseEntity<?> getAllConsents(@AuthenticationPrincipal Patient patient){
    String patientId = patient.getId();
    List<Consent> consent_list = webClient.get().uri(consentServer + "patient/getall?patientid=" + patientId).retrieve().bodyToFlux(Consent.class).collectList().block();
    return ResponseEntity.ok(consent_list);
  }

  @PutMapping("/update-consent")
  ResponseEntity<?> updateConsents(@RequestParam("consent_id") String consent_id, @RequestBody Map<String, String> payload){
    String response = webClient.put().uri(consentServer+"patient/update?consent_id=" + consent_id).bodyValue(payload).retrieve().bodyToMono(String.class).block();
    return ResponseEntity.accepted().body(response);
  }

  @GetMapping("/get-records")
  ResponseEntity<?> getRecords(@AuthenticationPrincipal Patient patient, @RequestParam("hospital_id") String hos_id){
    String patientId =  patient.getId();
    List<PatientRecord> pr_list = webClient.get().uri(hospitalManager + "/api/v1/patient-records/get-records-hospital?patient_id="+ patientId + "&hospital_id=" +hos_id).retrieve().bodyToFlux(PatientRecord.class).collectList().block();
    return ResponseEntity.accepted().body(pr_list);
  }

}
