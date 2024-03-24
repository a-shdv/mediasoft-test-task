package com.company.productswarehouse.services.impl;

import com.company.productswarehouse.entities.Product;
import com.company.productswarehouse.exceptions.ProductAlreadyExistsException;
import com.company.productswarehouse.exceptions.ProductNotFoundException;
import com.company.productswarehouse.repos.ProductRepo;
import com.company.productswarehouse.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(UUID uuid) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findById(uuid);
        if (!product.isPresent()) {
            throw new ProductNotFoundException("Товар не найден!");
        }
        return product.get();
    }

    @Override
    public Product save(Product product) throws ProductAlreadyExistsException {
        if (productRepo.findById(product.getId()).isPresent()) {
            throw new ProductAlreadyExistsException("Товар уже существует!");
        }
        return productRepo.save(product);
    }

    // TODO
    @Override
    public Product edit(Product product) throws ProductNotFoundException {
/*        if (!productRepo.findById(product.getId()).isPresent()) {
            throw new ProductNotFoundException("Товар не найден!");
        }
        return null;*/
        return null;
    }

    @Override
    public UUID delete(Product product) throws ProductNotFoundException {
        UUID productId = product.getId();
        if (!productRepo.findById(productId).isPresent()) {
            throw new ProductNotFoundException("Товар не найден!");
        }
        productRepo.deleteById(productId);
        return productId;
    }
}
