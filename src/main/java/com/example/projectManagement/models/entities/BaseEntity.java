package com.example.projectManagement.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(value = {AuditingEntityListener.class} )
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    protected Integer id;
    @CreatedDate
    protected LocalDate createdAt;
    @LastModifiedDate
    protected LocalDate updatedAt;
    private boolean active = true;
}