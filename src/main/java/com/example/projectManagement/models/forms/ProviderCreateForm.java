package com.example.projectManagement.models.forms;

import com.example.projectManagement.models.entities.Product;
import com.example.projectManagement.models.entities.Provider;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Data
public class ProviderCreateForm {

    private Integer id;
private String name;
private String address;



    public Provider toBll() {
        Provider entity = new Provider();
        entity.setId(id);
        entity.setName(name);
        entity.setAddress(address);
        return entity;
    }
}
