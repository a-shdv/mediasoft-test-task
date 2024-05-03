package com.company.productswarehouse.exceptions.categories;

import com.company.productswarehouse.exceptions.categories.CategoryAlreadyExistsException;
import com.company.productswarehouse.exceptions.categories.CategoryListIsEmptyException;
import com.company.productswarehouse.exceptions.categories.CategoryNotFoundException;
import com.company.productswarehouse.exceptions.products.ProductAlreadyExistsException;
import com.company.productswarehouse.exceptions.products.ProductListIsEmptyException;
import com.company.productswarehouse.exceptions.products.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CategoryExceptionHandler {
    @ExceptionHandler({CategoryAlreadyExistsException.class})
    public ResponseEntity<?> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException categoryAlreadyExistsException) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(categoryAlreadyExistsException.getMessage());
    }

    @ExceptionHandler({CategoryNotFoundException.class})
    public ResponseEntity<?> handleCategoryNotFoundException(CategoryNotFoundException categoryNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(categoryNotFoundException.getMessage());
    }

    @ExceptionHandler({CategoryListIsEmptyException.class})
    public ResponseEntity<?> handleCategoryListIsEmptyException(CategoryListIsEmptyException categoryListIsEmptyException) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(categoryListIsEmptyException.getMessage());
    }
}
