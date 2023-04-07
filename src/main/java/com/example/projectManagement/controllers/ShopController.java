package com.example.projectManagement.controllers;

import com.example.projectManagement.exceptions.HttpNotFoundException;
import com.example.projectManagement.models.entities.Provider;
import com.example.projectManagement.models.entities.Shop;
import com.example.projectManagement.models.forms.ProviderCreateForm;
import com.example.projectManagement.models.forms.ShopCreateForm;
import com.example.projectManagement.services.provider.ProviderService;
import com.example.projectManagement.services.shop.ShopService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = {"/shop"})
public class ShopController implements BaseRestController<Shop, Integer> {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }


    @GetMapping
    public ResponseEntity<Collection<Shop>> readAll(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(this.shopService.readAll(pageable).toList());
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<Shop> readOne(
            @PathVariable Integer id
    ) {
        Shop shop = this.shopService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Shop with id(" + id + ") is not found"));

        return ResponseEntity.ok(shop);

    }
    @PostMapping
    public ResponseEntity<Shop> insert(@RequestBody ShopCreateForm form) {
        Shop shop = this.shopService.save(form.toBll());
        return ResponseEntity.ok(shop);
    }

    @PatchMapping
    public ResponseEntity<Shop> update(@RequestBody ShopCreateForm form) {
        Shop shop = this.shopService.save(form.toBll());
        return ResponseEntity.ok(shop);
    }
}