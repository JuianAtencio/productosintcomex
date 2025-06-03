package com.intcomex.productosintcomex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.intcomex.productosintcomex")
@EntityScan(basePackages = "com.intcomex.productosintcomex.infrastructure.entity")
public class ProductosintcomexApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosintcomexApplication.class, args);
	}

}
