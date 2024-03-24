package com.company.productswarehouse.services;

import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.exceptions.CategoryAlreadyExistsException;
import com.company.productswarehouse.exceptions.CategoryNotFoundException;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> findAll();

    Category findById(UUID uuid) throws CategoryNotFoundException;

    Category save(Category category) throws CategoryAlreadyExistsException;

    Category edit(Category category) throws CategoryNotFoundException;

    Category delete(Category category) throws CategoryNotFoundException;
}
