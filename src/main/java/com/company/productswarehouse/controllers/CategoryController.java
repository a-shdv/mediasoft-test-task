package com.company.productswarehouse.controllers;

import com.company.productswarehouse.dtos.CategoryDto;
import com.company.productswarehouse.exceptions.categories.CategoryAlreadyExistsException;
import com.company.productswarehouse.exceptions.categories.CategoryListIsEmptyException;
import com.company.productswarehouse.exceptions.categories.CategoryNotFoundException;
import com.company.productswarehouse.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Tag(name = "Category", description = "API для категорий")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Получить список всех категорий")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findAll() throws CategoryListIsEmptyException {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("{id}")
    @Operation(summary = "Получить категорию по id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findById(@PathVariable UUID id) throws CategoryNotFoundException {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Создать новую категорию")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> save(@RequestBody @Valid CategoryDto categoryDto) throws CategoryAlreadyExistsException {
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

    @PutMapping("{id}")
    @Operation(summary = "Обновить категорию по id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> editById(@PathVariable UUID id, @RequestBody @Valid CategoryDto categoryDto) throws CategoryNotFoundException {
        return ResponseEntity.ok(categoryService.editById(id, categoryDto));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удалить категорию по id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteById(@PathVariable UUID id) throws CategoryNotFoundException {
        return ResponseEntity.ok(categoryService.deleteById(id));
    }
}
