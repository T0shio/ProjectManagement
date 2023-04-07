package com.example.projectManagement.models.dtos.shop;

import com.example.projectManagement.models.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShopDto {
    private Integer id;
    private String name;
    private String address;
    private List<Product> products;
}
