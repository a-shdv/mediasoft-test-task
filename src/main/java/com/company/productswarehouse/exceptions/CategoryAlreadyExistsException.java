package com.company.productswarehouse.exceptions;

public class CategoryAlreadyExistsException extends Exception {
    public CategoryAlreadyExistsException() {
    }

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
}
