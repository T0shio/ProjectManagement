package com.example.projectManagement.models.dtos.product;

import com.example.projectManagement.models.dtos.provider.ProviderDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer brand;

    private String providerName;
}
