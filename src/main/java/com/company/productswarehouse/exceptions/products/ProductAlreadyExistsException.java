package com.company.productswarehouse.exceptions.products;

public class ProductAlreadyExistsException extends Exception {
    public ProductAlreadyExistsException() {
    }

    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
