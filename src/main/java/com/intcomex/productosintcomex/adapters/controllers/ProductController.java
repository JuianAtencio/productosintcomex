package com.intcomex.productosintcomex.adapters.controllers;

import com.intcomex.productosintcomex.application.ProductService;
import com.intcomex.productosintcomex.adapters.dto.ProductDTO;
import com.intcomex.productosintcomex.adapters.mappers.ProductMapper;
import com.intcomex.productosintcomex.domain.Product;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = ProductMapper.toDomain(productDTO);
        Product saved = productService.save(product);
        return ResponseEntity.ok(ProductMapper.toDTO(saved));
    }

    /*@GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }*/

    @GetMapping("/")
    public ResponseEntity<Page<ProductDTO>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer categoryId
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.findAllPaged(name, categoryId, pageable);
        Page<ProductDTO> dtoPage = productPage.map(ProductMapper::toDTO);
        return ResponseEntity.ok(dtoPage);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        return productService.findById(id)
                .map(ProductMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para carga masiva (puedes ajustar la lógica según tu necesidad)
    /*@PostMapping("/bulk")
    public ResponseEntity<List<ProductDTO>> createProductsBulk(@RequestBody List<ProductDTO> productDTOs) {
        List<ProductDTO> savedProducts = productDTOs.stream()
                .map(ProductMapper::toDomain)
                .map(productService::save)
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(savedProducts);
    }*/


    @PostMapping("/bulk")
    public ResponseEntity<List<ProductDTO>> createProductsBulk(@RequestBody List<ProductDTO> productDTOs) {
        List<Product> products = productDTOs.stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
        List<Product> saved = productService.saveAll(products);
        List<ProductDTO> result = saved.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/test")
    public ResponseEntity<List<ProductDTO>> testProducts() {
        List<ProductDTO> products = productService.findAll()
            .stream()
            .map(ProductMapper::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }
}
