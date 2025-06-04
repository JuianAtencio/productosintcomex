package com.intcomex.productosintcomex.adapters.controllers;

import com.intcomex.productosintcomex.application.CategoryService;
import com.intcomex.productosintcomex.adapters.dto.CategoryDTO;
import com.intcomex.productosintcomex.adapters.mappers.CategoryMapper;
import com.intcomex.productosintcomex.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CategoryControllerTest {

    private CategoryService categoryService;
    private CategoryController controller;

    @BeforeEach
    void setUp() {
        categoryService = mock(CategoryService.class);
        controller = new CategoryController(categoryService);
    }

    @Test
    void createCategory_ReturnsCreatedCategory() {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(1);
        dto.setCategoryName("TestCat");
        Category category = CategoryMapper.toDomain(dto);

        when(categoryService.save(any(Category.class))).thenReturn(category);

        ResponseEntity<CategoryDTO> response = controller.createCategory(dto);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(dto.getCategoryId(), response.getBody().getCategoryId());
        assertEquals(dto.getCategoryName(), response.getBody().getCategoryName());
    }

    @Test
    void getAllCategories_ReturnsList() {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(1);
        dto.setCategoryName("TestCat");
        Category category = CategoryMapper.toDomain(dto);
        when(categoryService.findAll()).thenReturn(Arrays.asList(category));

        ResponseEntity<List<CategoryDTO>> response = controller.getAllCategories();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals("TestCat", response.getBody().get(0).getCategoryName());
    }

    @Test
    void getCategoryById_Found() {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(1);
        dto.setCategoryName("TestCat");
        Category category = CategoryMapper.toDomain(dto);
        when(categoryService.findById(1)).thenReturn(Optional.of(category));

        ResponseEntity<CategoryDTO> response = controller.getCategoryById(1);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getCategoryId());
        assertEquals("TestCat", response.getBody().getCategoryName());
    }

    @Test
    void getCategoryById_NotFound() {
        when(categoryService.findById(2)).thenReturn(Optional.empty());

        ResponseEntity<CategoryDTO> response = controller.getCategoryById(2);

        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}
