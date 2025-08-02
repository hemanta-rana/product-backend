package com.Product.backend.products.controller;

import com.Product.backend.products.dto.CategoryDTO;
import com.Product.backend.products.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    // get categories
    // create categories
    @PostMapping
    public ResponseEntity<CategoryDTO >  createCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryDTO));

    }

}
