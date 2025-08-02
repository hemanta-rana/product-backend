package com.Product.backend.products.service;

import com.Product.backend.products.config.CategoryMapper;
import com.Product.backend.products.dto.CategoryDTO;
import com.Product.backend.products.entity.Category;
import com.Product.backend.products.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // create category

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
       category=  categoryRepository.save(category);
       return CategoryMapper.toCategoryDTO(category);

    }
    // get all category
    // get category by id
    // delete category
}
