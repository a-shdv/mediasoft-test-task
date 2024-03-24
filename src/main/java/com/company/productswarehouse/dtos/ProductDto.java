package com.company.productswarehouse.dtos;

import com.company.productswarehouse.entities.Product;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDto(
        @Getter String article,
        @Getter String title,
        @Getter String description,
        @Getter BigDecimal price,
        @Getter Integer amount,
        @Getter UUID categoryId
) {
    public static Product toProduct(ProductDto productDto) {
        return Product.builder()
                .article(productDto.article)
                .title(productDto.title)
                .description(productDto.description)
                .price(productDto.price)
                .amount(productDto.amount)
                .build();
    }
}
