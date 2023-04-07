package com.example.projectManagement.services.provider;

import com.example.projectManagement.models.entities.Provider;
import com.example.projectManagement.repositories.ProviderRepository;
import com.example.projectManagement.services.CrudServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;
@Service
public class ProviderServiceImpl extends CrudServiceImpl<ProviderRepository, Provider, Integer> implements ProviderService {
    protected ProviderServiceImpl(ProviderRepository providerRepository) {
        super(providerRepository);
    }
    @Override
    @Transactional
    public Stream<Provider> readAll() {
        return super.readAll();
    }
}

