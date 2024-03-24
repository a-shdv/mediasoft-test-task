package com.company.productswarehouse.exceptions;

public class ProductListIsEmptyException extends Exception {
    public ProductListIsEmptyException() {
    }

    public ProductListIsEmptyException(String message) {
        super(message);
    }
}
