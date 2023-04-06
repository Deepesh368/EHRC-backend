package com.example.hospital_manager.controller;

import com.example.hospital_manager.entity.HospitalAddr;
import com.example.hospital_manager.payload.PatientRecord;
import com.example.hospital_manager.repo.HospitalAddrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient-records")
public class PatientRecordsController{
    @Autowired
    private HospitalAddrRepo hospitalAddrRepo;
    @Autowired private WebClient webClient;

    @GetMapping("/get-records-hospital")
    ResponseEntity<?> getRecords(@RequestParam("patient_id") String patientId, @RequestParam("hospital_id") String hos_id){
        HospitalAddr h= hospitalAddrRepo.findHospitalAddrById(hos_id);
        String port = h.getAddr();
        List<PatientRecord> pr_list = webClient.get().uri("http://localhost:"+port+"/records/find_all?patient_id="+ patientId).retrieve().bodyToFlux(PatientRecord.class).collectList().block();
        return ResponseEntity.accepted().body(pr_list);
    }
}
