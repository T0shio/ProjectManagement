package com.example.projectManagement.controllers;

import com.example.projectManagement.exceptions.HttpNotFoundException;
import com.example.projectManagement.models.entities.Product;
import com.example.projectManagement.models.entities.Provider;
import com.example.projectManagement.models.forms.ProductCreateForm;
import com.example.projectManagement.models.forms.ProviderCreateForm;
import com.example.projectManagement.services.product.ProductService;
import com.example.projectManagement.services.provider.ProviderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = {"/provider"})
public class ProviderController implements BaseRestController<Provider, Integer> {
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }


    @GetMapping
    public ResponseEntity<Collection<Provider>> readAll(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(this.providerService.readAll().toList());
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<Provider> readOne(
            @PathVariable Integer id
    ) {
        Provider provider = this.providerService.readOneByKey(id).orElseThrow(()
                -> new HttpNotFoundException("Provider with id(" + id + ") is not found"));
        return ResponseEntity.ok(provider);

    }
    @PostMapping
    public ResponseEntity<Provider> insert(@RequestBody ProviderCreateForm form) {
        Provider provider = this.providerService.save(form.toBll());
        return ResponseEntity.ok(provider);
    }

    @PutMapping()
    public ResponseEntity<Provider> update(@RequestBody ProviderCreateForm form) {
        System.out.println(form);
        Provider provider = this.providerService.save(form.toBll());
        return ResponseEntity.ok(provider);
    }
    @DeleteMapping
    public ResponseEntity<Provider> delete(@RequestBody ProviderCreateForm form){
        Provider provider = this.providerService.save(form.toBll());
        return ResponseEntity.ok(provider);
    }
}
