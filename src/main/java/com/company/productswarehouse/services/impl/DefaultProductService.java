package com.company.productswarehouse.services.impl;

import com.company.productswarehouse.dtos.ProductDto;
import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.entities.Product;
import com.company.productswarehouse.exceptions.ProductAlreadyExistsException;
import com.company.productswarehouse.exceptions.ProductListIsEmptyException;
import com.company.productswarehouse.exceptions.ProductNotFoundException;
import com.company.productswarehouse.repos.CategoryRepo;
import com.company.productswarehouse.repos.ProductRepo;
import com.company.productswarehouse.services.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    @Override
    @Transactional
    public List<Product> findAll() throws ProductListIsEmptyException {
        List<Product> products = productRepo.findAll();
        if (products.isEmpty()) {
            throw new ProductListIsEmptyException("Список товаров пуст!");
        }
        return products;
    }

    @Override
    @Transactional
    public Product findById(UUID uuid) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findById(uuid);
        if (!product.isPresent()) {
            throw new ProductNotFoundException("Товар не найден!");
        }
        return product.get();
    }

    @Override
    @Transactional
    public Product save(ProductDto productDto) throws ProductAlreadyExistsException {
        Product product = ProductDto.toProduct(productDto);
        Optional<Category> category = categoryRepo.findById(productDto.getCategoryId());
        if (productRepo.findByTitle(product.getTitle()).isPresent()) {
            throw new ProductAlreadyExistsException("Товар уже существует!");
        }
        if (category.isPresent()) {
            product.setCategory(category.get());
        }
        return productRepo.save(product);
    }

    // TODO
    @Override
    @Transactional
    public UUID editById(UUID id, ProductDto productDto) throws ProductNotFoundException {
        Optional<Product> dbProduct = productRepo.findById(id);
        Product product = ProductDto.toProduct(productDto);
        if (!dbProduct.isPresent()) {
            throw new ProductNotFoundException("Товар не найден!");
        }

        dbProduct.get().setTitle(product.getTitle());

        productRepo.save(dbProduct.get());
        return dbProduct.get().getId();
    }

    @Override
    @Transactional
    public UUID deleteById(UUID id) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findById(id);
        UUID productId = product.get().getId();
        if (!product.isPresent()) {
            throw new ProductNotFoundException("Товар не найден!");
        }
        productRepo.deleteById(productId);
        return productId;
    }
}
