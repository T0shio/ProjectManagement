package com.example.projectManagement.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
public interface BaseRestController<TEntity, TKey> {
    ResponseEntity<TEntity> readOne(TKey id);

}
