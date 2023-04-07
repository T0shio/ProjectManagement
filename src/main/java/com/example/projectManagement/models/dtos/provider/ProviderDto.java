package com.example.projectManagement.models.dtos.provider;


import com.example.projectManagement.models.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProviderDto {
    private Integer id;
    private String nameProvider;
    private List<Product> productsProvided;
}
