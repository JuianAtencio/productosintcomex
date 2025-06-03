package com.intcomex.productosintcomex.infrastructure;

import com.intcomex.productosintcomex.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Integer> {
    
    Page<ProductEntity> findByProductNameContainingIgnoreCaseAndCategoryId(
        String productName, Integer categoryId, Pageable pageable
    );

    @Query("SELECT p FROM ProductEntity p " +
           "WHERE (:name IS NULL OR LOWER(p.productName) LIKE LOWER(CONCAT('%', :name, '%'))) " +
           "AND (:categoryId IS NULL OR p.categoryId = :categoryId)")
    Page<ProductEntity> searchProducts(
        @Param("name") String name,
        @Param("categoryId") Integer categoryId,
        Pageable pageable
    );
}
