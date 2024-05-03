package com.company.productswarehouse;

import com.company.productswarehouse.dtos.CategoryDto;
import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.exceptions.categories.CategoryAlreadyExistsException;
import com.company.productswarehouse.exceptions.categories.CategoryListIsEmptyException;
import com.company.productswarehouse.exceptions.categories.CategoryNotFoundException;
import com.company.productswarehouse.repos.CategoryRepo;
import com.company.productswarehouse.services.impl.DefaultCategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DefaultCategoryServiceTest {

    @Mock
    private CategoryRepo categoryRepo;

    @InjectMocks
    private DefaultCategoryService categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category());
        Mockito.when(categoryRepo.findAll()).thenReturn(categories);

        Assertions.assertDoesNotThrow(() -> categoryService.findAll());
    }

    @Test
    public void testFindAllEmptyList() {
        Mockito.when(categoryRepo.findAll()).thenReturn(new ArrayList<>());

        Assertions.assertThrows(CategoryListIsEmptyException.class, () -> categoryService.findAll());
    }

    @Test
    public void testFindById() {
        UUID id = UUID.randomUUID();
        Category category = new Category();
        Mockito.when(categoryRepo.findById(id)).thenReturn(Optional.of(category));

        Assertions.assertEquals(category, categoryService.findById(id));
    }

    @Test
    public void testFindByIdNotFound() {
        UUID id = UUID.randomUUID();
        Mockito.when(categoryRepo.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(CategoryNotFoundException.class, () -> categoryService.findById(id));
    }

    @Test
    public void testSave() {
        CategoryDto categoryDto = new CategoryDto("Test Category");
        Category category = new Category();
        category.setTitle("Test Category");

        Mockito.when(categoryRepo.findByTitle(category.getTitle())).thenReturn(Optional.empty());
        Mockito.when(categoryRepo.save(Mockito.any(Category.class))).thenReturn(category);

        Assertions.assertDoesNotThrow(() -> categoryService.save(categoryDto));
    }

    @Test
    public void testSaveAlreadyExists() {
        CategoryDto categoryDto = new CategoryDto("Test Category");
        Category category = new Category();
        category.setTitle("Test Category");
        Mockito.when(categoryRepo.findByTitle(category.getTitle())).thenReturn(Optional.of(category));

        Assertions.assertThrows(CategoryAlreadyExistsException.class, () -> categoryService.save(categoryDto));
    }
}
