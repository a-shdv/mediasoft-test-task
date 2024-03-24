package com.company.productswarehouse;

import com.company.productswarehouse.entities.Product;
import com.company.productswarehouse.exceptions.products.ProductListIsEmptyException;
import com.company.productswarehouse.exceptions.products.ProductNotFoundException;
import com.company.productswarehouse.repos.ProductRepo;
import com.company.productswarehouse.services.impl.DefaultProductService;
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

public class DefaultProductServiceTest {
    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private DefaultProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        Mockito.when(productRepo.findAll()).thenReturn(products);

        Assertions.assertDoesNotThrow(() -> productService.findAll());
    }

    @Test
    public void testFindAllEmptyList() {
        Mockito.when(productRepo.findAll()).thenReturn(new ArrayList<>());

        Assertions.assertThrows(ProductListIsEmptyException.class, () -> productService.findAll());
    }

    @Test
    public void testFindById() {
        UUID id = UUID.randomUUID();
        Product product = new Product();
        Mockito.when(productRepo.findById(id)).thenReturn(Optional.of(product));

        Assertions.assertEquals(product, productService.findById(id));
    }

    @Test
    public void testFindByIdNotFound() {
        UUID id = UUID.randomUUID();
        Mockito.when(productRepo.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.findById(id));
    }
}
