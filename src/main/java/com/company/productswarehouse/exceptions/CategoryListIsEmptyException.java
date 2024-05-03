package com.company.productswarehouse.exceptions;

public class CategoryListIsEmptyException extends Exception {
    public CategoryListIsEmptyException() {
    }

    public CategoryListIsEmptyException(String message) {
        super(message);
    }
}
