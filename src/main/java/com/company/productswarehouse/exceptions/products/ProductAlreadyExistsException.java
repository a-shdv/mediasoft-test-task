package com.company.productswarehouse.exceptions.products;

public class ProductAlreadyExistsException extends ProductException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
