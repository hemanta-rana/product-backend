package com.Product.backend.products.config;

import com.Product.backend.products.dto.CategoryDTO;
import com.Product.backend.products.entity.Category;

public class CategoryMapper {

    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }

    public static CategoryDTO toCategoryDTO(Category category){
        if (category == null){
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts());



        return categoryDTO;
    }


}
