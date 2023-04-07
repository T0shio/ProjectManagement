package com.example.projectManagement.models.forms;

import com.example.projectManagement.models.entities.Product;
import com.example.projectManagement.models.entities.Provider;
import lombok.Data;

@Data
public class ProductCreateForm {

    private Integer id;

    private String name;
    private String description;
    private Integer price;
    private Integer quantity;
    private String brand;
    private String category;
    private Integer providerId;

    public Product toBll(){
        Product entity = new Product();
        entity.setId(id);
        entity.setName(name);
        entity.setDescription(description);
        entity.setPrice(price);
        entity.setBrand(brand);
        entity.setCategory(category);
        return entity;
    }
}

