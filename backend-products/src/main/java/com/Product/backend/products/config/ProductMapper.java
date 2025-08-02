package com.Product.backend.products.config;

import com.Product.backend.products.dto.ProductDTO;
import com.Product.backend.products.entity.Category;
import com.Product.backend.products.entity.Product;


public class ProductMapper {

    //entity to dto
    public static ProductDTO toProductDto (Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    // dto to entity
    public static  Product toProductEntity(ProductDTO productDTO, Category category){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return  product;
    }
}
