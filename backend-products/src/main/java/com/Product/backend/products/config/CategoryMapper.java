package com.Product.backend.products.config;

import com.Product.backend.products.dto.CategoryDTO;
import com.Product.backend.products.dto.ProductDTO;
import com.Product.backend.products.entity.Category;

import java.util.List;

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
        if (category.getProducts() != null) {
            List<ProductDTO> productDTOs = category.getProducts().stream()
                    .map(ProductMapper::toProductDto)
                    .toList();
            categoryDTO.setProducts(productDTOs);
        }
        return categoryDTO;
    }


}
