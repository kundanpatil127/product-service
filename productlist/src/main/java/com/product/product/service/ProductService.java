package com.product.product.service;

import com.product.product.dto.ProductDto;
import com.product.product.entity.Category;
import com.product.product.entity.Product;
import com.product.product.exception.CategoryNotFoundException;
import com.product.product.exception.ProductAlreadyExistException;
import com.product.product.exception.ProductNotFoundException;
import com.product.product.mapper.ProductMapper;
import com.product.product.repository.CategoryRepository;
import com.product.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public ProductDto createNewProduct(ProductDto productDto) {
        //find category is present or not
       Category category =  categoryRepository.findById(productDto.getCategoryId())
               .orElseThrow(()-> new CategoryNotFoundException("Category not found :"+productDto.getCategoryId()));

      Optional<Product> productOptional =  productRepository.findByName(productDto.getName());
      if (productOptional.isPresent()){
          throw new ProductAlreadyExistException("Product "+productDto.getName()+" is already present in list");
      }

       Product product =  ProductMapper.toProductEntity(productDto,category);
       product =  productRepository.save(product);
       return ProductMapper.toProductDto(product);
    }

    public ProductDto getProduct(Long id) {
      Product product =  productRepository.findById(id)
              .orElseThrow(()-> new ProductNotFoundException("Product not found: "+id));
      return ProductMapper.toProductDto(product);
    }

    public List<ProductDto> getAllProduct() {
        return productRepository.findAll().stream().map(ProductMapper::toProductDto).toList();
    }

    public ProductDto updateProductData(ProductDto productDto, Long id) {
       Product product = productRepository.findById(id)
               .orElseThrow(()-> new ProductNotFoundException("Product not found"));
       Category category = categoryRepository.findById(productDto.getCategoryId())
               .orElseThrow(()->new CategoryNotFoundException("CATEGORY NOT FOUND "+id));
       product.setName(productDto.getName());
       product.setDescription(productDto.getDescription());
       product.setCategory(category);
       product.setPrice(productDto.getPrice());
       productRepository.save(product);
       return ProductMapper.toProductDto(product);
    }

    public String deleteById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product not found "));
        productRepository.deleteById(id);
        return "Product deleted successfully..!";
    }
}
