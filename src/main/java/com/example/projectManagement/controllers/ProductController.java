package com.example.projectManagement.controllers;

import com.example.projectManagement.exceptions.HttpNotFoundException;
import com.example.projectManagement.models.entities.Product;
import com.example.projectManagement.models.entities.Provider;
import com.example.projectManagement.models.forms.ProductCreateForm;
import com.example.projectManagement.services.product.ProductService;
import com.example.projectManagement.services.provider.ProviderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = {"/product"})
public class ProductController implements BaseRestController<Product, Integer> {
    private final ProductService productService;
    private final ProviderService providerService;

    public ProductController(ProductService productService, ProviderService providerService) {
        this.productService = productService;
        this.providerService = providerService;
    }


    @GetMapping
    public ResponseEntity<Collection<Product>> readAll(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(this.productService.readAll(pageable).toList());
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<Product> readOne(
            @PathVariable Integer id
    ) {
        Product product = this.productService.readOneByKey(id).orElseThrow(()
                -> new HttpNotFoundException("Employee with id(" + id + ") is not found"));
        return ResponseEntity.ok(product);

    }
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductCreateForm form) {
        Product product = this.productService.save(form.toBll());
        Optional<Provider> opt = this.providerService.readOneByKey(form.getProviderId());
        product.setProvider(opt.orElseThrow(() -> new HttpNotFoundException("Provider with id(" + form.getProviderId() + ") is not found")));
        return ResponseEntity.ok(product);
    }

    @PatchMapping
    public ResponseEntity<Product> update(@RequestBody ProductCreateForm form) {
        Product product = this.productService.save(form.toBll());
        return ResponseEntity.ok(product);
    }
    @DeleteMapping
    public ResponseEntity<Product> delete(@RequestBody ProductCreateForm form){
        Product product = this.productService.save(form.toBll());
        return ResponseEntity.ok(product);
    }
}
