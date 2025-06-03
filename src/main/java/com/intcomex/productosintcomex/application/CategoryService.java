package com.intcomex.productosintcomex.application;

import com.intcomex.productosintcomex.domain.Category;
import com.intcomex.productosintcomex.domain.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

}
