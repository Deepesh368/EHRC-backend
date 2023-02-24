package com.consent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsentManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsentManagerApplication.class, args);
    }

    public RestTemplate restTemplate () { return new RestTemplate();}
}
