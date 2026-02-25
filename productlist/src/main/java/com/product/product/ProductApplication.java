package com.product.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "Product Service REST API Documentation",
				description = "Product service REST API",
				version = "1",
				contact = @Contact(
						name = "Kundan Patil",
						email = "kpatil7494@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "URL product service REST Api",
				url = "www.google.com"
		)
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
