package com.company.productswarehouse.services;

import com.company.productswarehouse.entities.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> findAll();

    Category findById(UUID uuid);

    Category save();

    Category edit();

    Category delete(Category product);
}
