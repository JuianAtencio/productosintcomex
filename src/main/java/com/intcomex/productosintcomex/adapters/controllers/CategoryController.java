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

    /**
     * Endpoint para crear una nueva categoría.
     * Convierte el DTO a dominio, lo guarda y devuelve el DTO de la categoría creada.
     * @param categoryDTO
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toDomain(categoryDTO);
        Category saved = categoryService.save(category);
        return ResponseEntity.ok(CategoryMapper.toDTO(saved));
    }

    /**
     * Endpoint para obtener todas las categorías.
     * Convierte la lista de categorías del dominio a DTO y las devuelve.
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.findAll()
                .stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

    /**
     * Endpoint para obtener una categoría por su ID.
     * Busca la categoría por ID, la convierte a DTO y la devuelve.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Integer id) {
        return categoryService.findById(id)
                .map(CategoryMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
