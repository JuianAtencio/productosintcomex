package com.intcomex.productosintcomex.infrastructure;

import com.intcomex.productosintcomex.domain.Category;
import com.intcomex.productosintcomex.domain.CategoryRepository;
import com.intcomex.productosintcomex.infrastructure.entity.CategoryEntity;
import com.intcomex.productosintcomex.adapters.mappers.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositoryAdapter implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;

    public CategoryRepositoryAdapter(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }

    @Override
    public Category save(Category category) {
        CategoryEntity entity = CategoryMapper.toEntity(category);
        CategoryEntity saved = categoryJpaRepository.save(entity);
        return CategoryMapper.toDomain(saved);
    }

    @Override
    public List<Category> findAll() {
        return categoryJpaRepository.findAll()
                .stream()
                .map(CategoryMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> findById(Integer categoryId) {
        return categoryJpaRepository.findById(categoryId)
                .map(CategoryMapper::toDomain);
    }

    @Override
    public Optional<Category> findByName(String categoryName) {
        return categoryJpaRepository.findByCategoryName(categoryName)
                .map(CategoryMapper::toDomain);
    }
}
