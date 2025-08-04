package com.Product.backend.products;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "product service REST API documentation ",
				description = "Product service REST API",
				version = "v1",
				contact = @Contact(
						name = "admish",
						email = ""
				)
		)
)
@SpringBootApplication
public class BackendProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendProductsApplication.class, args);
	}

}
