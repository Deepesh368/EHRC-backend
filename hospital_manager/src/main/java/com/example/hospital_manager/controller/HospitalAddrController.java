package com.example.hospital_manager.controller;

import com.example.hospital_manager.entity.HospitalAddr;
import com.example.hospital_manager.payload.Consent;
import com.example.hospital_manager.payload.HospitalAddrRequest;
import com.example.hospital_manager.repo.HospitalAddrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController("/hospital-addr")
public class HospitalAddrController {
    @Autowired
    private HospitalAddrRepo hospitalAddrRepo;
    @Autowired private WebClient webClient;
    private HashMap<String, String> convert(String res) {
        HashMap<String, String> map = new HashMap<>();
        map.put("response", res);
        return map;
    }
    @PostMapping("/add-hospital")
    public ResponseEntity<?> add(@RequestBody HospitalAddrRequest hospitalAddrRequest){
        var addr = HospitalAddr.builder()
                .addr(hospitalAddrRequest.getAddr())
                .id(hospitalAddrRequest.getId())
                .name(hospitalAddrRequest.getName())
                .build();
        hospitalAddrRepo.save(addr);
        String response = "saved";
        return ResponseEntity.accepted().body(addr);
    }
    @GetMapping("/doctor/get-consent/{hospital_id}/{doctor_id}")
    public ResponseEntity<?>get_consents_doctor(@PathVariable Integer doctor_id,String hospital_id){
        List<Consent>s_list = webClient.get().uri("http://localhost:9091/consent/doctor/"+hospital_id+"/"+doctor_id).retrieve().bodyToFlux(Consent.class).collectList().block();
        return ResponseEntity.accepted().body(s_list);
    }
    @GetMapping("/patient/get-consent/{patient_id}")
    public ResponseEntity<?>get_consents_patient(@PathVariable Integer patient_id){
        List<Consent>s_list = webClient.get().uri("http://localhost:9091/consent/patient/"+patient_id).retrieve().bodyToFlux(Consent.class).collectList().block();
        return ResponseEntity.accepted().body(s_list);
    }
    @PostMapping("/create-consent")
   public ResponseEntity<?>post_consent(@RequestBody Consent consent){
        String response = "forwarded";
        webClient.post().uri("http://localhost:9091/consent/doctor/create").bodyValue(consent).retrieve().bodyToMono(Consent.class).block();
        return ResponseEntity.accepted().body(convert(response));
    }


}
