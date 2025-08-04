package com.Product.backend.products.controller;

import com.Product.backend.products.dto.ProductDTO;
import com.Product.backend.products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    // get all products
    @GetMapping
    public ResponseEntity<List<ProductDTO>>  getAllProducts(){
       return ResponseEntity.ok(productService.getAllProduct());

    }
    // create product
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity< ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDTO));

    }
    // update product
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ResponseEntity <ProductDTO> updateProduct(@RequestBody ProductDTO productDTO,@PathVariable Long id){
        productService.updateProduct(id, productDTO);
      return  ResponseEntity.noContent().build();


    }
    // by id
    @GetMapping("/{id}")
    public ResponseEntity <ProductDTO> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));

    }

    // delete product form id
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


}
