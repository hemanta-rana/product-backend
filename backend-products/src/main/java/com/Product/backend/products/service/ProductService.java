package com.Product.backend.products.service;

import com.Product.backend.products.dto.ProductDTO;
import com.Product.backend.products.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProduct();

    ProductDTO getProductById(Long id);

    void deleteProduct(Long id);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);
}
