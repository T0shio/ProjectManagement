package com.example.projectManagement.services.stock;

import com.example.projectManagement.models.entities.Stock;
import com.example.projectManagement.services.CrudService;

import java.util.stream.Stream;

public interface StockService extends CrudService<Stock, Integer> {
    Stream<Stock> findAllByActive(boolean active);
}
