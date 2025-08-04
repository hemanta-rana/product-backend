package com.Product.backend.products.repository;

import com.Product.backend.products.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
      Optional<Category>findByName(String categoryName);
}
