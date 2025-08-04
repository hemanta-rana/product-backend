package com.Product.backend.products.service;

import com.Product.backend.products.dto.ProductDTO;
import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProduct();

    ProductDTO getProductById(Long id);

    void deleteProduct(Long id);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);
}
