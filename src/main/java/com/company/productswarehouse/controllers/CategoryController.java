package com.company.productswarehouse.controllers;

import com.company.productswarehouse.dtos.CategoryDto;
import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.exceptions.CategoryAlreadyExistsException;
import com.company.productswarehouse.exceptions.CategoryListIsEmptyException;
import com.company.productswarehouse.exceptions.CategoryNotFoundException;
import com.company.productswarehouse.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(categoryService.findAll());
        } catch (CategoryListIsEmptyException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(categoryService.findById(id));
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CategoryDto categoryDto) {
        try {
            return ResponseEntity.ok(categoryService.save(categoryDto));
        } catch (CategoryAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> editById(@PathVariable UUID id, @RequestBody Category category) {
        try {
            return ResponseEntity.ok(categoryService.editById(id, category));
        } catch (CategoryNotFoundException houseNotFoundException) {
            return ResponseEntity.badRequest().body(houseNotFoundException.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id, @RequestBody Category category) {
        try {
            return ResponseEntity.ok(categoryService.deleteById(id));
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
