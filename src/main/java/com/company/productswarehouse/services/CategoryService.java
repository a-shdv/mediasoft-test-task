package com.company.productswarehouse.services;

import com.company.productswarehouse.dtos.CategoryDto;
import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.exceptions.categories.CategoryAlreadyExistsException;
import com.company.productswarehouse.exceptions.categories.CategoryListIsEmptyException;
import com.company.productswarehouse.exceptions.categories.CategoryNotFoundException;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> findAll() throws CategoryListIsEmptyException;

    Category findById(UUID uuid) throws CategoryNotFoundException;

    Category save(CategoryDto categoryDto) throws CategoryAlreadyExistsException;

    UUID editById(UUID id, CategoryDto categoryDto) throws CategoryNotFoundException;

    UUID deleteById(UUID id) throws CategoryNotFoundException;
}
