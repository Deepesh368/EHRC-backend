package com.example.hosptial_service.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hosptial_service.entity.PatientRecord;
import com.example.hosptial_service.service.PatientRecordService;

@RestController
@RequestMapping("/records")
public class PatientRecordController {
    @Autowired
    public PatientRecordService patientRecordService;
    private HashMap<String, String> convert(String res) {
        HashMap<String, String> map = new HashMap<>();
        map.put("response", res);
        return map;
    }
    @PostMapping("/add")
    public ResponseEntity<?> savePatientRecord(@RequestBody PatientRecord patientRecord){
         String response = patientRecordService.newUser(patientRecord);
         return ResponseEntity.accepted().body(convert(response));
    }
    @GetMapping("/find_all/{patient_id}")
    public List<PatientRecord> findByPatientId(@PathVariable("patient_id") String patient_id){
        return  patientRecordService.findByPatientId(patient_id);

    }
    @GetMapping("/find_all/{from}/{to}/{patient_id}")
    public List<PatientRecord> findByDateOfVisitAndPatientId(@PathVariable("from") Date d1,@PathVariable("to") Date d2,@PathVariable("patient_id") String patient_id){
        return patientRecordService.findByDateOfVisitAndPatientId(d1, d2, patient_id);

    }

     

    
}
