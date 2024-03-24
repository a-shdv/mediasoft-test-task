package com.company.productswarehouse.exceptions.products;

public class ProductListIsEmptyException extends Exception {
    public ProductListIsEmptyException() {
    }

    public ProductListIsEmptyException(String message) {
        super(message);
    }
}
