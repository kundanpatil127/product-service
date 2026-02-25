package com.product.product.service;

import com.product.product.dto.CategoryDto;
import com.product.product.entity.Category;
import com.product.product.exception.CategoryAlreadyExistException;
import com.product.product.exception.CategoryNotFoundException;
import com.product.product.mapper.CategoryMapper;
import com.product.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //create categories
    public CategoryDto createCategory(CategoryDto categoryDto){

        Optional<Category> categoryOptional = categoryRepository.findByName(categoryDto.getName());

        if (categoryOptional.isPresent()){
            throw new CategoryAlreadyExistException("Category "+categoryDto.getName()+" is already exist");
        }

        Category category = CategoryMapper.toCategoryEntity(categoryDto);
       category =  categoryRepository.save(category);
       return  CategoryMapper.toCategoryDto(category);

    }

    //fetch categories
    public CategoryDto fetchCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException("category not found "+id));
        return CategoryMapper.toCategoryDto(category);
    }

    //get all categories
    public List<CategoryDto> fetchAllData(){
       return  categoryRepository.findAll()
               .stream().map(CategoryMapper::toCategoryDto).toList();
    }

    //delete categories
    public String deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new CategoryNotFoundException("Category not found :" +id));
        categoryRepository.deleteById(id);
        return "Categories "+id+" deleted";
    }
}
