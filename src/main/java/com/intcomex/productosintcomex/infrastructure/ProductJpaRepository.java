package com.intcomex.productosintcomex.infrastructure;

import com.intcomex.productosintcomex.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Integer> {
    
    /**
     * Método para buscar productos por nombre y categoría.
     * Permite filtrar por nombre (case-insensitive) y por ID de categoría.
     * @param productName
     * @param categoryId
     * @param pageable
     * @return
     */
    Page<ProductEntity> findByProductNameContainingIgnoreCaseAndCategoryId(
        String productName, Integer categoryId, Pageable pageable
    );

    /**
     * Método para buscar productos por nombre y categoría.
     * Permite filtrar por nombre (case-insensitive) y por ID de categoría.
     * @param name
     * @param categoryId
     * @param pageable
     * @return
     */
    @Query("SELECT p FROM ProductEntity p " +
           "WHERE (:name IS NULL OR LOWER(p.productName) LIKE LOWER(CONCAT('%', :name, '%'))) " +
           "AND (:categoryId IS NULL OR p.categoryId = :categoryId)")
    Page<ProductEntity> searchProducts(
        @Param("name") String name,
        @Param("categoryId") Integer categoryId,
        Pageable pageable
    );
}
