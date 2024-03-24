package com.company.productswarehouse.services;

import com.company.productswarehouse.dtos.ProductDto;
import com.company.productswarehouse.entities.Product;
import com.company.productswarehouse.exceptions.products.ProductAlreadyExistsException;
import com.company.productswarehouse.exceptions.products.ProductListIsEmptyException;
import com.company.productswarehouse.exceptions.products.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> findAll() throws ProductListIsEmptyException;

    Product findById(UUID uuid) throws ProductNotFoundException;

    Product save(ProductDto productDto) throws ProductAlreadyExistsException;

    UUID editById(UUID id, ProductDto productDto) throws ProductNotFoundException;

    UUID deleteById(UUID id) throws ProductNotFoundException;
}
