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

@RestController
@RequestMapping("/hospital-addr")
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
    @GetMapping("/doctor/get-consents/{doctor_id}/{hospital_id}")
    public ResponseEntity<?>get_consents_doctor(@PathVariable Integer doctor_id,@PathVariable String hospital_id){
//        List<Consent>s_list =webClient.get()
//                .uri(uriBuilder -> uriBuilder.path("http://localhost:9002/consent/get/doctor")
//                        .queryParam("doctor_id", doctorId)
//                        .queryParam("hospital_id", hospitalId)
//                        .build())
//                .retrieve()
//                .bodyToFlux(Consent.class).collectList().block();
        List<Consent>s_list = webClient.get().uri("http://localhost:9002/consent/get/doctor/"+doctor_id+"/"+hospital_id).retrieve().bodyToFlux(Consent.class).collectList().block();
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
        webClient.post().uri("http://localhost:9002/consent/doctor/create").bodyValue(consent).retrieve().bodyToMono(Consent.class).block();
        return ResponseEntity.accepted().body(convert(response));
    }


}
