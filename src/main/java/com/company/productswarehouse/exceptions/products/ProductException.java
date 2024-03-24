package com.company.productswarehouse.exceptions.products;

public class ProductException extends RuntimeException {
    public ProductException() {
    }

    public ProductException(String message) {
        super(message);
    }
}
