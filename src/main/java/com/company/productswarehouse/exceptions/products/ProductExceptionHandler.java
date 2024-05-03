package com.company.productswarehouse.exceptions.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler({ProductAlreadyExistsException.class})
    public ResponseEntity<?> handleProductAlreadyExistsException(ProductAlreadyExistsException productAlreadyExistsException) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(productAlreadyExistsException.getMessage());
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(productNotFoundException.getMessage());
    }

    @ExceptionHandler({ProductListIsEmptyException.class})
    public ResponseEntity<?> handleProductListIsEmptyException(ProductListIsEmptyException productListIsEmptyException) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(productListIsEmptyException.getMessage());
    }
}
