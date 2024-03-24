package com.company.productswarehouse.exceptions.categories;

public class CategoryAlreadyExistsException extends Exception {
    public CategoryAlreadyExistsException() {
    }

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
}
