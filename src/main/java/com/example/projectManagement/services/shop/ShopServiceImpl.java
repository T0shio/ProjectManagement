package com.example.projectManagement.services.shop;

import com.example.projectManagement.models.entities.Shop;
import com.example.projectManagement.repositories.ShopRepository;
import com.example.projectManagement.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;
@Service
public class ShopServiceImpl extends CrudServiceImpl<ShopRepository, Shop, Integer> implements ShopService {
    protected ShopServiceImpl(ShopRepository shopRepository) {
        super(shopRepository);
    }
    @Override
    public Stream<Shop> readAll() {
        return super.readAll();
    }
}
