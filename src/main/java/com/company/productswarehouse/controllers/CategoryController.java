package com.company.productswarehouse.controllers;

import com.company.productswarehouse.dtos.CategoryDto;
import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.exceptions.categories.CategoryAlreadyExistsException;
import com.company.productswarehouse.exceptions.categories.CategoryListIsEmptyException;
import com.company.productswarehouse.exceptions.categories.CategoryNotFoundException;
import com.company.productswarehouse.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> findAll() throws CategoryListIsEmptyException {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) throws CategoryNotFoundException {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CategoryDto categoryDto) throws CategoryAlreadyExistsException {
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> editById(@PathVariable UUID id, @RequestBody CategoryDto categoryDto) throws CategoryNotFoundException {
        return ResponseEntity.ok(categoryService.editById(id, categoryDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id, @RequestBody Category category) throws CategoryNotFoundException {
        return ResponseEntity.ok(categoryService.deleteById(id));
    }
}
