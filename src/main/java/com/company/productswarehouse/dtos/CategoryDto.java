package com.company.productswarehouse.dtos;

import com.company.productswarehouse.entities.Category;
import lombok.Getter;

public record CategoryDto(@Getter String title) {
    public CategoryDto(String title) {
        this.title = title;
    }

    public static Category toCategory(CategoryDto categoryDto) {
        return Category.builder()
                .title(categoryDto.title())
                .build();
    }
}
