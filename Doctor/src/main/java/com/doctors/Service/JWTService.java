package com.doctors.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class JWTService {

    int expiry = 30;
    String Secret = "dsjaldk4768sad4546gvs7896vx";
    public String generateToken(String userName){
        Map<String, Objects> claims = new HashMap<>();
        return createToken(claims,userName);
    }

    private String createToken(Map<String, Objects> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*expiry))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(Secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
