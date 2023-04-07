package com.example.projectManagement.repositories;

import com.example.projectManagement.models.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p from Product p where p.name = :name")
    Optional<Product> findByName(@Param("name") String name);
}
