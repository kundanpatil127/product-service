package com.product.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "product",
        description = "It holds product Information"
)
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long categoryId;

//    public ProductDto(Long id, String name, String description, Double price, Long categoryId) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.categoryId = categoryId;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
