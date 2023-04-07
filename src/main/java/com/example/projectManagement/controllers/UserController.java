package com.example.projectManagement.controllers;

import com.example.projectManagement.exceptions.HttpNotFoundException;
import com.example.projectManagement.models.entities.Stock;
import com.example.projectManagement.models.entities.User;
import com.example.projectManagement.models.forms.StockCreateForm;
import com.example.projectManagement.models.forms.UserCreateForm;
import com.example.projectManagement.repositories.UserRepository;
import com.example.projectManagement.services.stock.StockService;
import com.example.projectManagement.services.user.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = {"/user"})
public class UserController implements BaseRestController<User, Integer> {
    private final UserService userService;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public UserController(UserService userService, PasswordEncoder encoder,
                          UserRepository userRepository) {
        this.userService = userService;
        this.encoder = encoder;
        this.userRepository = userRepository;
    }


    @GetMapping
    public ResponseEntity<Collection<User>> readAll(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(this.userService.readAll(pageable).toList());
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<User> readOne(
            @PathVariable Integer id
    ) {
        User user = this.userService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("User with id(" + id + ") is not found"));

        return ResponseEntity.ok(user);

    }
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserCreateForm form) {
        System.out.println(form);
        User user = form.toBll();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @PatchMapping
    public ResponseEntity<User> update(@RequestBody UserCreateForm form) {
        User user = this.userService.save(form.toBll());
        return ResponseEntity.ok(user);
    }
}