package com.product.product.mapper;

import com.product.product.dto.ProductDto;
import com.product.product.entity.Category;
import com.product.product.entity.Product;

public class ProductMapper {

    //entity to dto

    public static ProductDto toProductDto(Product product){

//        return new ProductDto(
//                product.getId(),
//                product.getName(),
//                product.getDescription(),
//                product.getPrice(),
//                product.getCategory().getId()
//        );
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setId(product.getId());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());
        return productDto;
    }

    //dto to entity
    public static Product toProductEntity(ProductDto productDto, Category category){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        return product;
    }
}
