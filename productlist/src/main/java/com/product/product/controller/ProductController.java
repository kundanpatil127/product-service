package com.product.product.controller;

import com.product.product.dto.ProductDto;
import com.product.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Percentage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product REST API CURD Operation",
        description = "CREATE, READ, UPDATE, DELETE Operation for product REST API"
)
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //get all product
    @Operation(
            summary = "fetch all product from products",
            description = "REST API for fetch all products"
    )
    @GetMapping
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    }

    //create product
    @Operation(
            summary = "create product",
            description = "REST API for create product"
    )
    @ApiResponse(
            responseCode = "201",
            description = "created"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createNewProduct(productDto), HttpStatus.CREATED);
    }

    //update product
    @Operation(
            summary = "Update product by using productId",
            description = "REST API for update product by productId"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id){
        return productService.updateProductData(productDto,id);
    }

    //get product by id
    @Operation(
            summary = "fetch product by product Id",
            description = "REST API for fetch product by Id"
    )
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productService.getProduct(id);
    }

    //delete product
    @Operation(
            summary = "delete product by product Id",
            description = "REST API for delete product by Id"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteById(id);
    }

}
