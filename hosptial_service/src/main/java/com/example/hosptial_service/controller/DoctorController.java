package com.example.hosptial_service.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hosptial_service.entity.Doctor;
import com.example.hosptial_service.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    private HashMap<String, String> convert(String res) {
        HashMap<String, String> map = new HashMap<>();
        map.put("response", res);
        return map;
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestHeader("email") String email, @RequestHeader("password") String password) {
        String response = doctorService.login(email, password);
        if(response.equals("not-found") || response.equals("incorrect-passowrd")){
            return ResponseEntity.badRequest().body(convert(response));
        }
        return ResponseEntity.accepted().body(convert(response));
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("email") String email) {
        String response = doctorService.logout(email);
        if(response.equals("not-found")){
            return ResponseEntity.badRequest().body(convert(response));
        }
        return ResponseEntity.accepted().body(convert(response));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> saveDoctor(@RequestBody Doctor user){
         String response = doctorService.newUser(user);
         return ResponseEntity.accepted().body(convert(response));
    }    
}
