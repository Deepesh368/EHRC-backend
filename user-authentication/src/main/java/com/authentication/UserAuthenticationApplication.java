package com.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthenticationApplication.class, args);
    }

    public RestTemplate restTemplate() { return new RestTemplate();}
}
