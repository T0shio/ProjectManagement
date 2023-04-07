package com.example.projectManagement.models.forms;

import com.example.projectManagement.models.entities.Product;
import com.example.projectManagement.models.entities.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockCreateForm {
    private ProductCreateForm product;
    private Integer quantity;

    public Stock toBll() {
        Stock entity = new Stock();
        entity.setQuantity(quantity);
        entity.setProduct(product.toBll());
        return entity;
    }}
