package com.example.projectManagement.controllers;

import com.example.projectManagement.exceptions.HttpNotFoundException;
import com.example.projectManagement.models.entities.Product;
import com.example.projectManagement.models.entities.Shop;
import com.example.projectManagement.models.entities.Stock;
import com.example.projectManagement.models.forms.ProductCreateForm;
import com.example.projectManagement.models.forms.ShopCreateForm;
import com.example.projectManagement.models.forms.StockCreateForm;
import com.example.projectManagement.services.shop.ShopService;
import com.example.projectManagement.services.stock.StockService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.Collection;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = {"/stocks"})
public class StockController implements BaseRestController<Stock, Integer> {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }


    @GetMapping("")
    public ResponseEntity<Collection<Stock>> readAll() {
        return ResponseEntity.ok(this.stockService.findAllByActive(true).toList());
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<Stock> readOne(
            @PathVariable Integer id
    ) {
        Stock stock = this.stockService.readOneByKey(id).orElseThrow(()
                -> new HttpNotFoundException("Stock with id(" + id + ") is not found"));
        return ResponseEntity.ok(stock);

    }
    @PostMapping
    public ResponseEntity<Stock> insert(@RequestBody StockCreateForm form) {
        Stock stock = form.toBll();
        this.stockService.save(stock);
        return ResponseEntity.ok(stock);
    }
    @PutMapping (path = "/{id:[0-9]+}")
    public ResponseEntity<Stock> update(@RequestBody StockCreateForm form, @PathVariable Integer id) {
        Stock toUpdate = this.stockService.readOneByKey(id).orElseThrow(()
                -> new HttpNotFoundException("There is no product with this ID : " + id));
        toUpdate.setQuantity(form.getQuantity());
        toUpdate.setProduct(form.getProduct().toBll());
        this.stockService.save(toUpdate);
        return ResponseEntity.ok(toUpdate);
    }
    @DeleteMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<Stock> delete(@PathVariable Integer id){
        Stock stock = this.stockService.readOneByKey(id).orElseThrow(()
                -> new HttpNotFoundException("Product doesn't exist anymore"));
        stock.setActive(false);
        this.stockService.save(stock);
        return ResponseEntity.ok(stock);
}
}
