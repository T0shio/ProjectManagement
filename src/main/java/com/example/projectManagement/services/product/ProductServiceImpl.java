package com.example.projectManagement.services.product;

import com.example.projectManagement.models.entities.Product;
import com.example.projectManagement.repositories.ProductRepository;
import com.example.projectManagement.services.CrudServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;
@Service
public class ProductServiceImpl extends CrudServiceImpl<ProductRepository, Product, Integer> implements ProductService {
    protected ProductServiceImpl(ProductRepository productRepository) {
        super(productRepository);
    }
    @Transactional
    @Override
    public Stream<Product> readAll() {
        return super.readAll();

    }
}
