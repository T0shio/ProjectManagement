package com.example.projectManagement.models.forms;

import com.example.projectManagement.models.entities.Product;
import com.example.projectManagement.models.entities.Provider;
import com.example.projectManagement.models.entities.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopCreateForm {

    private String name;
    private String address;
    private Product products;


    public Shop toBll() {
        Shop entity = new Shop();
        entity.setName(name);
        entity.setAddress(address);
        entity.setProducts(new ArrayList<Product>());
        return entity;
    }
}
