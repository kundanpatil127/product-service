package com.product.product.controller;

import com.product.product.dto.CategoryDto;
import com.product.product.exception.CategoryAlreadyExistException;
import com.product.product.mapper.CategoryMapper;
import com.product.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Category REST API CURD Operation",
        description = "CREATE, READ, UPDATE, DELETE Operation for category REST API"
)
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    //create categories

    @Operation(
            summary = "Create category ",
            description = "REST API to create product"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto){

        //handle custom exception by using try catch block  now handle global exception handle
//        try {
//            CategoryDto savedCategory = categoryService.createCategory(categoryDto);
//            return  ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//        }
//        catch (CategoryAlreadyExistException ex){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
//        }

        return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    //get category by id
    @Operation(
            summary = "Fetch category by categoryId",
             description = "REST API for fetch category by  category Id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> fetchId(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.fetchCategory(id), HttpStatus.FOUND);
    }

    //get all categories
    @Operation(
            summary = "Fetch All categories ",
            description = "REST API for fetch All categories "
    )
    @GetMapping
    public List<CategoryDto> fetchAllCategories(){
        return categoryService.fetchAllData();
    }

    //delete category
    @Operation(
          summary = "Delete category by CategoryId",
            description = "REST API for delete category by categoryId"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteByIdCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}
