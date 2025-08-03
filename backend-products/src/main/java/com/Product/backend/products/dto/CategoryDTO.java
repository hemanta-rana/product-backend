package com.Product.backend.products.dto;

import com.Product.backend.products.entity.Product;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name ;
    private List<ProductDTO> products;
}
