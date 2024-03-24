package com.company.productswarehouse.services;

import com.company.productswarehouse.dtos.CategoryDto;
import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.exceptions.CategoryAlreadyExistsException;
import com.company.productswarehouse.exceptions.CategoryListIsEmptyException;
import com.company.productswarehouse.exceptions.CategoryNotFoundException;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> findAll() throws CategoryListIsEmptyException;

    Category findById(UUID uuid) throws CategoryNotFoundException;

    Category save(CategoryDto categoryDto) throws CategoryAlreadyExistsException;

    UUID editById(UUID id, Category category) throws CategoryNotFoundException;

    UUID deleteById(UUID id) throws CategoryNotFoundException;
}
