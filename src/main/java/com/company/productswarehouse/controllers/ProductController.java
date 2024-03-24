package com.company.productswarehouse.controllers;

import com.company.productswarehouse.dtos.ProductDto;
import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.exceptions.CategoryNotFoundException;
import com.company.productswarehouse.exceptions.ProductAlreadyExistsException;
import com.company.productswarehouse.exceptions.ProductListIsEmptyException;
import com.company.productswarehouse.exceptions.ProductNotFoundException;
import com.company.productswarehouse.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(productService.findAll());
        } catch (ProductListIsEmptyException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(productService.findById(id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductDto productDto) {
        try {
            return ResponseEntity.ok(productService.save(productDto));
        } catch (ProductAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // TODO
    @PutMapping("{id}")
    public ResponseEntity<?> editById(@PathVariable UUID id, @RequestBody ProductDto productDto) {
        try {
            return ResponseEntity.ok(productService.editById(id, productDto));
        } catch (ProductNotFoundException houseNotFoundException) {
            return ResponseEntity.badRequest().body(houseNotFoundException.toString());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id, @RequestBody Category category) {
        try {
            return ResponseEntity.ok(productService.deleteById(id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
