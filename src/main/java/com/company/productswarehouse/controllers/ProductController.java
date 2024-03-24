package com.company.productswarehouse.controllers;

import com.company.productswarehouse.dtos.ProductDto;
import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.exceptions.products.ProductAlreadyExistsException;
import com.company.productswarehouse.exceptions.products.ProductListIsEmptyException;
import com.company.productswarehouse.exceptions.products.ProductNotFoundException;
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
    public ResponseEntity<?> findAll() throws ProductListIsEmptyException {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductDto productDto) throws ProductAlreadyExistsException {
        return ResponseEntity.ok(productService.save(productDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> editById(@PathVariable UUID id, @RequestBody ProductDto productDto) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.editById(id, productDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id, @RequestBody Category category) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.deleteById(id));
    }
}
