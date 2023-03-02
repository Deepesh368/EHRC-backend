package com.consent.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    private String uniqueID;
    private String name;

    private String email;
    private String password;
    private String phone;
    private String userType;
    private String authToken;

    public Patient(String name, String email, String password, String phone, String userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }

    public Patient() {
    }

    public Patient(String uniqueID, String name, String email, String password, String phone, String userType) {
        this.uniqueID = uniqueID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }
}
