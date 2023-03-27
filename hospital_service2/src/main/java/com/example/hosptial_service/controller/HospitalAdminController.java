package com.example.hosptial_service.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class HospitalAdminController {
    private HashMap<String, String> convert(String res) {
        HashMap<String, String> map = new HashMap<>();
        map.put("response", res);
        return map;
    }
   
    
}
