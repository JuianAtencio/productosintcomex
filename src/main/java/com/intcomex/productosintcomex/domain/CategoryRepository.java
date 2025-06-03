package com.intcomex.productosintcomex.domain;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    
    Category save(Category category);
    List<Category> findAll();
    Optional<Category> findById(Integer categoryId);
    Optional<Category> findByName(String categoryName);
}
