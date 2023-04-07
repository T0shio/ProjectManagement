package com.example.projectManagement.models.dtos.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String firstName;
    private String address;
}
