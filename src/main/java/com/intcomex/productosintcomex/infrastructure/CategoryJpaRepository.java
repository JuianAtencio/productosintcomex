package com.intcomex.productosintcomex.infrastructure;

import com.intcomex.productosintcomex.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Integer> {
    Optional<CategoryEntity> findByCategoryName(String categoryName);
}
