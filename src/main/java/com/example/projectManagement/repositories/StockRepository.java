package com.example.projectManagement.repositories;

import com.example.projectManagement.models.entities.Product;
import com.example.projectManagement.models.entities.Stock;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
//    @Query(value = "SELECT s FROM Shop sh JOIN FETCH sh.stock s WHERE s.id = :id")
//    Optional<Stock> findByShopId(@Param("id") Integer id);
@Transactional
Stream<Stock> findAllByActive(boolean active);
}
