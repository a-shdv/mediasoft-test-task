package com.company.productswarehouse.controllers;

import com.company.productswarehouse.dtos.ProductDto;
import com.company.productswarehouse.entities.Product;
import com.company.productswarehouse.exceptions.products.ProductAlreadyExistsException;
import com.company.productswarehouse.exceptions.products.ProductListIsEmptyException;
import com.company.productswarehouse.exceptions.products.ProductNotFoundException;
import com.company.productswarehouse.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Product", description = "API для товаров")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @Operation(summary = "Получить список всех товаров")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findAll() throws ProductListIsEmptyException {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("{id}")
    @Operation(summary = "Получить товар по id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findById(@PathVariable UUID id) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Создать новый товар")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> save(@RequestBody @Valid ProductDto productDto) throws ProductAlreadyExistsException {
        return ResponseEntity.ok(productService.save(productDto));
    }

    @PutMapping("{id}")
    @Operation(summary = "Обновить товар по id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> editById(@PathVariable UUID id, @RequestBody @Valid ProductDto productDto) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.editById(id, productDto));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удалить товар по id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteById(@PathVariable UUID id) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.deleteById(id));
    }
}
