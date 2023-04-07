package com.example.projectManagement.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Provider extends BaseEntity {

    @Column(nullable = false)
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    @ManyToOne
    private Shop shop;
}
