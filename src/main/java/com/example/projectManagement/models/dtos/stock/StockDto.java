package com.example.projectManagement.models.dtos.stock;

import com.example.projectManagement.models.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StockDto {
    private Integer id;
    private Integer quantity;
    private List<Product> products;

}
