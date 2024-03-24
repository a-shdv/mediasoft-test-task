package com.company.productswarehouse.services;

import com.company.productswarehouse.entities.Product;
import com.company.productswarehouse.exceptions.ProductAlreadyExistsException;
import com.company.productswarehouse.exceptions.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> findAll();

    Product findById(UUID uuid) throws ProductNotFoundException;

    Product save(Product product) throws ProductAlreadyExistsException;

    Product edit(Product product) throws ProductNotFoundException;

    UUID delete(Product product) throws ProductNotFoundException;
}
