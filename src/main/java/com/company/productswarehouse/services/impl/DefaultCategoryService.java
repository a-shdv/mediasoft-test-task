package com.company.productswarehouse.services.impl;

import com.company.productswarehouse.dtos.CategoryDto;
import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.exceptions.categories.CategoryAlreadyExistsException;
import com.company.productswarehouse.exceptions.categories.CategoryListIsEmptyException;
import com.company.productswarehouse.exceptions.categories.CategoryNotFoundException;
import com.company.productswarehouse.repos.CategoryRepo;
import com.company.productswarehouse.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Сервис для работы с категориями товаров.
 */
@Service
@RequiredArgsConstructor
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepo categoryRepo;


    /**
     * Получает список всех категорий товаров.
     *
     * @return Список категорий товаров.
     * @throws CategoryListIsEmptyException Если список категорий пуст.
     */
    @Override
    @Transactional
    public List<Category> findAll() throws CategoryListIsEmptyException {
        List<Category> categories = categoryRepo.findAll();
        if (categories.isEmpty()) {
            throw new CategoryListIsEmptyException("Список категорий пуст!");
        }
        return categories;
    }

    /**
     * Находит категорию товара по её идентификатору.
     *
     * @param uuid Идентификатор категории.
     * @return Найденная категория товара.
     * @throws CategoryNotFoundException Если категория не найдена.
     */
    @Override
    @Transactional
    public Category findById(UUID uuid) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepo.findById(uuid);
        if (!category.isPresent()) {
            throw new CategoryNotFoundException("Категория не найдена!");
        }
        return category.get();
    }

    /**
     * Сохраняет новую категорию товара.
     *
     * @param categoryDto DTO новой категории товара.
     * @return Сохранённая категория товара.
     * @throws CategoryAlreadyExistsException Если категория уже существует.
     */
    @Override
    @Transactional
    public Category save(CategoryDto categoryDto) throws CategoryAlreadyExistsException {
        Category category = CategoryDto.toCategory(categoryDto);
        if (categoryRepo.findByTitle(category.getTitle()).isPresent()) {
            throw new CategoryAlreadyExistsException("Категория уже существует!");
        }
        return categoryRepo.save(category);
    }

    /**
     * Редактирует категорию товара по её идентификатору.
     *
     * @param id          Идентификатор категории.
     * @param categoryDto DTO с обновлёнными данными категории товара.
     * @return Идентификатор отредактированной категории товара.
     * @throws CategoryNotFoundException Если категория не найдена.
     */
    @Override
    @Transactional
    public UUID editById(UUID id, CategoryDto categoryDto) throws CategoryNotFoundException {
        Optional<Category> dbCategory = categoryRepo.findById(id);
        Category category = CategoryDto.toCategory(categoryDto);
        if (!dbCategory.isPresent()) {
            throw new CategoryNotFoundException("Категория не найдена!");
        }
        dbCategory.get().setTitle(category.getTitle());
        categoryRepo.save(dbCategory.get());
        return dbCategory.get().getId();
    }

    /**
     * Удаляет категорию товара по её идентификатору.
     *
     * @param id Идентификатор категории.
     * @return Идентификатор удалённой категории товара.
     * @throws CategoryNotFoundException Если категория не найдена.
     */
    @Override
    @Transactional
    public UUID deleteById(UUID id) throws CategoryNotFoundException {
        if (!categoryRepo.findById(id).isPresent()) {
            throw new CategoryNotFoundException("Категория не найдена!");
        }
        categoryRepo.deleteById(id);
        return id;
    }
}
