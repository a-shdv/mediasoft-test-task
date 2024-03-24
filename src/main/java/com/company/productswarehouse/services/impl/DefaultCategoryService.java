package com.company.productswarehouse.services.impl;

import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.exceptions.CategoryAlreadyExistsException;
import com.company.productswarehouse.exceptions.CategoryNotFoundException;
import com.company.productswarehouse.repos.CategoryRepo;
import com.company.productswarehouse.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepo categoryRepo;


    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(UUID uuid) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepo.findById(uuid);
        if (!category.isPresent()) {
            throw new CategoryNotFoundException("Категория не найдена!");
        }
        return category.get();
    }

    @Override
    public Category save(Category category) throws CategoryAlreadyExistsException {
        if (categoryRepo.findById(category.getId()).isPresent()) {
            throw new CategoryAlreadyExistsException("Категория уже существует!");
        }
        return categoryRepo.save(category);
    }

    @Override
    public Category edit(Category category) throws CategoryNotFoundException {
        return null;
    }

    // TODO
    @Override
    public Category delete(Category category) throws CategoryNotFoundException {
        UUID categoryId = category.getId();
        if (!categoryRepo.findById(categoryId).isPresent()) {
            throw new CategoryNotFoundException("Категория не найдена!");
        }
        categoryRepo.deleteById(categoryId);
        return category;
    }
}
