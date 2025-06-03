package com.intcomex.productosintcomex.infrastructure;

import com.intcomex.productosintcomex.domain.Product;
import com.intcomex.productosintcomex.domain.ProductRepository;
import com.intcomex.productosintcomex.infrastructure.entity.ProductEntity;
import com.intcomex.productosintcomex.adapters.mappers.ProductMapper;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductMapper.toEntity(product);
        ProductEntity saved = productJpaRepository.save(entity);
        return ProductMapper.toDomain(saved);
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll()
                .stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }
/* 
    @Override
    public Page<Product> findAllPaged(String name, Integer categoryId, Pageable pageable) {
        Page<ProductEntity> page = productJpaRepository.findByProductNameContainingIgnoreCaseAndCategoryId(
            name != null ? name : "",
            categoryId,
            pageable
        );
        return page.map(ProductMapper::toDomain);
    }*/

    /*Con esto, si name o categoryId son null, el filtro se ignora y la búsqueda es más flexible.
     * Aquí cómo hacer que el filtro por categoría sea opcional usando una consulta personalizada en tu repositorio JPA:
    */
    
    @Override
    public Page<Product> findAllPaged(String name, Integer categoryId, Pageable pageable) {
        Page<ProductEntity> page = productJpaRepository.searchProducts(name, categoryId, pageable);
        return page.map(ProductMapper::toDomain);
    }

    @Override
    public Optional<Product> findById(Integer productId) {
        return productJpaRepository.findById(productId)
                .map(ProductMapper::toDomain);
    }

    @Override
    public void deleteById(Integer productId) {
        productJpaRepository.deleteById(productId);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        List<ProductEntity> entities = products.stream()
                .map(ProductMapper::toEntity)
                .collect(Collectors.toList());
        List<ProductEntity> saved = productJpaRepository.saveAll(entities);
        return saved.stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }
}
