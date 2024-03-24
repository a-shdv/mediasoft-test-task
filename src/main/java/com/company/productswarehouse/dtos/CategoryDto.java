package com.company.productswarehouse.dtos;

import com.company.productswarehouse.entities.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public record CategoryDto(
        @Getter
        @NotEmpty(message = "Название не должно быть пустым!")
        @Size(min = 5, max = 50)
        String title
) {
    public CategoryDto(String title) {
        this.title = title;
    }

    public static Category toCategory(CategoryDto categoryDto) {
        return Category.builder()
                .title(categoryDto.title)
                .build();
    }
}
