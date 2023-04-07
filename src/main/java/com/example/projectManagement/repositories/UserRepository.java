package com.example.projectManagement.repositories;

import com.example.projectManagement.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<UserDetails> findUserByUsername(String username);
}
