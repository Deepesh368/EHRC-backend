package com.authentication.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    private String uniqueID;
    private String name;

    private String email;
    private String password;
    private String phone;
    private String userType;
    private String authToken;

    public User(String name, String email, String password, String phone, String userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }

    public User() {
    }

    public User(String uniqueID, String name, String email, String password, String phone, String userType) {
        this.uniqueID = uniqueID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }
}
