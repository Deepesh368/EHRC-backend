package com.example.hospital_manager.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "hospital_addr")
public class HospitalAddr {
    @Id
    private String id;
    private String name;
    private String addr;
}
