package com.example.projectManagement.models.entities;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Stock extends BaseEntity {

    @Column(nullable = false)
    private Integer quantity;
//    @OneToMany(mappedBy = "stock")
//    private List<StockItem> items;
    @OneToOne
    private Product product;
}
