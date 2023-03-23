package com.doctors.Controller;

import com.doctors.Service.DoctorService;
import com.doctors.Service.JWTService;
import com.doctors.entity.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest){

    }
}
