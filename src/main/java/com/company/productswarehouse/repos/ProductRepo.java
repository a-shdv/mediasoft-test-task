package com.company.productswarehouse.repos;

import com.company.productswarehouse.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepo extends JpaRepository<Product, UUID> {
    Optional<Product> findByTitle(String title);
}
