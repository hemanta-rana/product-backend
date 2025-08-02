package com.Product.backend.products.repository;

import com.Product.backend.products.entity.Category;
import com.Product.backend.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
