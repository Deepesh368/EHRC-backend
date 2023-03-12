package com.example.hosptial_service.controller;

import java.util.HashMap;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hosptial_service.entity.ConsentedPatientRecord;
import com.example.hosptial_service.entity.Doctor;
import com.example.hosptial_service.repo.DoctorRepo;
import com.example.hosptial_service.service.ConsentedPatientRecordService;
import com.example.hosptial_service.service.DoctorService;
import com.example.hosptial_service.service.PatientRecordService;

@RestController
@RequestMapping("/consented")
public class ConsentedPatientRecordController {
    @Autowired
    private ConsentedPatientRecordService cs;
    @Autowired
    private DoctorService doctorService;
    private HashMap<String, String> convert(String res) {
        HashMap<String, String> map = new HashMap<>();
        map.put("response", res);
        return map;
    }
    @PostMapping("/add/{doctorId}")
    public ResponseEntity<?> saveRecord(@PathVariable (value="doctorId") String doctorId,@RequestBody ConsentedPatientRecord data){
        //System.out.println()
        Doctor d = doctorService.findById(doctorId);
        if(d != null){
            data.setDoctor(d);
        }
        else 
         throw new IllegalArgumentException("Cannot find doctor");
    
        String response = cs.save(data);
        return ResponseEntity.accepted().body(convert(response));
   }



    
}
