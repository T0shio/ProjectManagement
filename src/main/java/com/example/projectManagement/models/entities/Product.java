package com.example.projectManagement.models.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
@Setter
public class Product extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer price;

    private String description;

    private String category;

    private String brand;
    @ManyToOne
    private Shop shop;

    @ManyToOne
    private Provider provider;
}
