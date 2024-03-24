package com.company.productswarehouse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @NotEmpty(message = "Артикул не должен быть пустым!")
    @Size(min = 5, max = 255)
    private String article;

    @Column(unique = true)
    @NotEmpty(message = "Название не должно быть пустым!")
    @Size(min = 5, max = 50)
    private String title;

    @Column(columnDefinition = "text")
    @NotEmpty(message = "Описание не должно быть пустым!")
    @Size(min = 5)
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    private void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
