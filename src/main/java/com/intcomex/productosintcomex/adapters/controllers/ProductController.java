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

    /**
     * Endpoint para crear un nuevo producto.
     * Convierte el DTO a dominio, lo guarda y devuelve el DTO del producto creado.
     * @param productDTO
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = ProductMapper.toDomain(productDTO);
        Product saved = productService.save(product);
        return ResponseEntity.ok(ProductMapper.toDTO(saved));
    }

    /**
     * Endpoint para obtener todos los productos.
     * Permite paginación y filtrado por nombre y categoría.
     * @param page
     * @param size
     * @param name
     * @param categoryId
     * @return
     */
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

    /**
     * Endpoint para obtener un producto por su ID.
     * Busca el producto por ID, lo convierte a DTO y lo devuelve.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        return productService.findById(id)
                .map(ProductMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para actualizar un producto.
     * Convierte el DTO a dominio, lo actualiza y devuelve el DTO del producto actualizado.
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint para crear múltiples productos en una sola solicitud.
     * Convierte la lista de DTOs a dominio, los guarda y devuelve la lista de DTOs de los productos creados.
     * @param productDTOs
     * @return
     */
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

    /**
     * Endpoint de prueba para obtener todos los productos.
     * Convierte la lista de productos del dominio a DTO y los devuelve.
     * @return
     */
    @GetMapping("/test")
    public ResponseEntity<List<ProductDTO>> testProducts() {
        List<ProductDTO> products = productService.findAll()
            .stream()
            .map(ProductMapper::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    /**
     * Endpoint para actualizar el precio de un producto.
     * Busca el producto por ID, actualiza su precio y devuelve el DTO del producto actualizado.
     * @param id
     * @param newPrice
     * @return
     */
    @PutMapping("/{id}/price")
    public ResponseEntity<ProductDTO> updateProductPrice(@PathVariable Integer id, @RequestBody Double newPrice) {
        Product updated = productService.updatePrice(id, newPrice);
        if (updated != null) {
            return ResponseEntity.ok(ProductMapper.toDTO(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
