package com.Product.backend.products.controller;

import com.Product.backend.products.dto.CategoryDTO;
import com.Product.backend.products.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    // get all categories
    @GetMapping
    public ResponseEntity <List<CategoryDTO>> getAllCategories(){

        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    // create categories
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDTO >  createCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryDTO));

    }
    // get category by id
    @GetMapping("/{id}")
    public ResponseEntity< CategoryDTO>  getCategoryByID(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));

    }
    // delete category
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }


}
