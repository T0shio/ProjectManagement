package com.example.projectManagement.repositories;

import com.example.projectManagement.models.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}
