package com.intcomex.productosintcomex.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Integer productId);
    
    void deleteById(Integer productId);

    Page<Product> findAllPaged(String name, Integer categoryId, Pageable pageable);
    
    List<Product> saveAll(List<Product> products);
    
}
