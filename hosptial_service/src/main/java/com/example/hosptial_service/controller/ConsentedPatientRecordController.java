package com.example.hosptial_service.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hosptial_service.entity.ConsentedPatientRecord;
import com.example.hosptial_service.service.ConsentedPatientRecordService;
import com.example.hosptial_service.service.PatientRecordService;

@RestController
@RequestMapping("/access_consented")
public class ConsentedPatientRecordController {
    @Autowired
    private ConsentedPatientRecordService cs;
    private HashMap<String, String> convert(String res) {
        HashMap<String, String> map = new HashMap<>();
        map.put("response", res);
        return map;
    }
    @PostMapping("/add")
    public ResponseEntity<?> saveRecord(@RequestBody ConsentedPatientRecord data){
        String response = cs.save(data);
        return ResponseEntity.accepted().body(convert(response));
   }



    
}
