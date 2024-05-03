package com.company.productswarehouse.dtos;

import com.company.productswarehouse.entities.Product;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDto(
        @Getter
        @NotEmpty(message = "Артикул не должен быть пустым!")
        @Size(min = 5, max = 255)
        String article,

        @Getter
        @NotEmpty(message = "Название не должно быть пустым!")
        @Size(min = 5, max = 50)
        String title,

        @Getter
        @NotEmpty(message = "Описание не должно быть пустым!")
        @Size(min = 5)
        String description,

        @Getter
        @NotNull
        BigDecimal price,

        @Getter
        @NotNull
        Integer amount,

        @Getter
        UUID categoryId
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
