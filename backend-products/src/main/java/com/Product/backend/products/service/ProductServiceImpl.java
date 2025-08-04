package com.Product.backend.products.service;

import com.Product.backend.products.config.ProductMapper;
import com.Product.backend.products.dto.ProductDTO;
import com.Product.backend.products.entity.Category;
import com.Product.backend.products.entity.Product;
import com.Product.backend.products.exception.CategoryNotFoundException;
import com.Product.backend.products.exception.ProductNotFoundException;
import com.Product.backend.products.repository.CategoryRepository;
import com.Product.backend.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
      Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new CategoryNotFoundException("category id "+productDTO.getCategoryId()+ " not found "));
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        return ProductMapper.toProductDto(product);


    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = productList.stream()
                .map(product -> new ProductDTO(product.getId(),product.getName(), product.getDescription(), product.getPrice(),product.getCategory().getId()) ).toList();
        return productDTOList;

    }

    @Override
    public ProductDTO getProductById(Long id) {
       Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("product id "+ id+" not found "));

       return ProductMapper.toProductDto(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("product id "+ id+" not found "));
        productRepository.delete(product);
      
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("product id "+ id+" not found "));
       Category category =categoryRepository.findById(productDTO.getCategoryId())
               .orElseThrow(()-> new CategoryNotFoundException("category id not found "));

     product.setName(productDTO.getName());
     product.setDescription(productDTO.getDescription());
     product.setPrice(productDTO.getPrice());
     product.setCategory(category);
     productRepository.save(product);
     return ProductMapper.toProductDto(product);

    }
}
