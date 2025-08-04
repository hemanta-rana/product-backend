package com.Product.backend.products.service;

import com.Product.backend.products.config.CategoryMapper;
import com.Product.backend.products.dto.CategoryDTO;
import com.Product.backend.products.entity.Category;
import com.Product.backend.products.exception.CategoryAlreadyExistException;
import com.Product.backend.products.exception.CategoryNotFoundException;
import com.Product.backend.products.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // create category

    public CategoryDTO createCategory(CategoryDTO categoryDTO){

     Optional <Category> optionalCategory =  categoryRepository.findByName(categoryDTO.getName());
        if (optionalCategory.isPresent()){
            throw  new CategoryAlreadyExistException("Category "+categoryDTO.getName()+" already exist");
        }
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
       category=  categoryRepository.save(category);
       return CategoryMapper.toCategoryDTO(category);

    }

    public List<CategoryDTO> getAllCategories() {


       return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("category id not found"));
        return CategoryMapper.toCategoryDTO(category);
    }

    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("ID not found "));
        categoryRepository.delete(category);
    }
    // get all category
    // get category by id
    // delete category
}
