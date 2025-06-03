package com.intcomex.productosintcomex.adapters.controllers;

import com.intcomex.productosintcomex.application.CategoryService;
import com.intcomex.productosintcomex.adapters.dto.CategoryDTO;
import com.intcomex.productosintcomex.adapters.mappers.CategoryMapper;
import com.intcomex.productosintcomex.domain.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/Category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toDomain(categoryDTO);
        Category saved = categoryService.save(category);
        return ResponseEntity.ok(CategoryMapper.toDTO(saved));
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.findAll()
                .stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Integer id) {
        return categoryService.findById(id)
                .map(CategoryMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
