package com.company.productswarehouse.dtos;

import com.company.productswarehouse.entities.Product;

public record ProductDto() {
    public static Product toProduct(ProductDto productDto) {
        return Product.builder().build();
    }
}
