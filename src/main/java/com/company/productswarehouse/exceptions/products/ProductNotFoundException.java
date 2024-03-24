package com.company.productswarehouse.exceptions.products;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
