package com.intcomex.productosintcomex.application;

import com.intcomex.productosintcomex.domain.Product;
import com.intcomex.productosintcomex.domain.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Page<Product> findAllPaged(String name, Integer categoryId, Pageable pageable) {
        // Este método debe delegar la consulta a tu repositorio adaptador
        return productRepository.findAllPaged(name, categoryId, pageable);
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

}
