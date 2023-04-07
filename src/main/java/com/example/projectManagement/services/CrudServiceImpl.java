package com.example.projectManagement.services;

import com.example.projectManagement.exceptions.HttpNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;
import java.util.stream.Stream;
public abstract class CrudServiceImpl<Repository extends JpaRepository, TEntity, TKey extends Serializable> implements CrudService<TEntity, TKey> {
    protected final Repository repository;

    protected CrudServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public TEntity save(TEntity entity) {
        return (TEntity) this.repository.save(entity);
    }

    @Override
    public Stream<TEntity> readAll() {
        return this.repository.findAll().stream();
    }

    @Override
    public Optional<TEntity> readOneByKey(TKey tKey) {
        return this.repository.findById(tKey);
    }

    @Override
    public void delete(TKey tKey) {
        Optional<TEntity> entity = this.readOneByKey(tKey);
        entity.orElseThrow(() -> new HttpNotFoundException("Entity with key(" + tKey + ") doesn't exists"));
        entity.ifPresent(this::delete);
    }

    @Override
    public void delete(TEntity entity) {
        this.repository.delete(entity);
    }

    public Stream<TEntity> readAll(Pageable pageable) {
        return this.repository.findAll(pageable).stream();
    }}