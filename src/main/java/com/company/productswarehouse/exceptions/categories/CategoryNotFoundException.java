package com.company.productswarehouse.exceptions.categories;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException() {
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
