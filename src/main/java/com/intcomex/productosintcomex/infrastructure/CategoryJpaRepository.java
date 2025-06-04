package com.intcomex.productosintcomex.infrastructure;

import com.intcomex.productosintcomex.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Integer> {
    /**
     * Método para buscar una categoría por su nombre.
     * Permite filtrar por nombre (case-insensitive).
     * @param categoryName
     * @return
     */
    Optional<CategoryEntity> findByCategoryName(String categoryName);
}
