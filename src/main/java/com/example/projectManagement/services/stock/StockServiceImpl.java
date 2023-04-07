package com.example.projectManagement.services.stock;

import com.example.projectManagement.models.entities.Product;
import com.example.projectManagement.models.entities.Stock;
import com.example.projectManagement.repositories.ProductRepository;
import com.example.projectManagement.repositories.StockRepository;
import com.example.projectManagement.services.CrudServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Service
public class StockServiceImpl extends CrudServiceImpl<StockRepository, Stock, Integer> implements StockService {

    private final ProductRepository productRepository;
    protected StockServiceImpl(StockRepository stockRepository, ProductRepository productRepository) {
        super(stockRepository);
        this.productRepository = productRepository;
    }


    @Override
    public Stock save(Stock stock) {

        Product product = null;
        if(stock.getProduct().getId() != null){
            product = stock.getProduct();
        }else {
            product = Product.builder()
                    .name(stock.getProduct().getName())
                    .price(stock.getProduct().getPrice())
                    .description(stock.getProduct().getDescription())
                    .brand(stock.getProduct().getBrand())
                    .build();
        }
        this.productRepository.save(product);
        stock.setProduct(product);

        return this.repository.save(stock);
    }

    @Override
    @Transactional
    public Stream<Stock> findAllByActive(boolean active) {
        return this.repository.findAllByActive(true);
    }
}

