package com.example.projectManagement.repositories;

import com.example.projectManagement.models.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
