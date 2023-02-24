package com.authentication.controller;
import com.authentication.entity.User;
import com.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    private HashMap<String, String> convert(String res) {
        HashMap<String, String> map = new HashMap<>();
        map.put("response", res);
        return map;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestHeader("email") String email, @RequestHeader("password") String password) {
        String response = userService.login(email, password);
        if(response.equals("not-found") || response.equals("incorrect-passowrd")){
            return ResponseEntity.badRequest().body(convert(response));
        }
        return ResponseEntity.accepted().body(convert(response));
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("email") String email) {
        String response = userService.logout(email);
        if(response.equals("not-found")){
            return ResponseEntity.badRequest().body(convert(response));
        }
        return ResponseEntity.accepted().body(convert(response));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> saveQuestion(@RequestBody User user){
         String response = userService.newUser(user);
         return ResponseEntity.accepted().body(convert(response));

    }
}
