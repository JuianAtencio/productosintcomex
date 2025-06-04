package com.intcomex.productosintcomex.adapters.mappers;

import com.intcomex.productosintcomex.domain.Category;
import com.intcomex.productosintcomex.infrastructure.entity.CategoryEntity;
import com.intcomex.productosintcomex.adapters.dto.CategoryDTO;

public class CategoryMapper {

    /**
     * Convierte un objeto Category a su representación DTO.
     * Si el objeto Category es null, devuelve null.
     * @param category
     * @return
     */
    public static CategoryDTO toDTO(Category category) {
        if (category == null) return null;
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        dto.setDescription(category.getDescription());
        dto.setPicture(category.getPicture());
        return dto;
    }

    /**
     * Convierte un objeto CategoryDTO a su representación de dominio.
     * Si el objeto CategoryDTO es null, devuelve null.
     * @param dto
     * @return
     */
    public static Category toDomain(CategoryDTO dto) {
        if (dto == null) return null;
        Category category = new Category();
        category.setCategoryId(dto.getCategoryId());
        category.setCategoryName(dto.getCategoryName());
        category.setDescription(dto.getDescription());
        category.setPicture(dto.getPicture());
        return category;
    }

    /**
     * Convierte un objeto Category a su representación de entidad.
     * @param category
     * @return
     */
    public static CategoryEntity toEntity(Category category) {
        if (category == null) return null;
        CategoryEntity entity = new CategoryEntity();
        entity.setCategoryId(category.getCategoryId());
        entity.setCategoryName(category.getCategoryName());
        entity.setDescription(category.getDescription());
        entity.setPicture(category.getPicture());
        return entity;
    }

    /**
     * Convierte un objeto CategoryEntity a su representación de dominio.
     * Si el objeto CategoryEntity es null, devuelve null.
     * @param entity
     * @return
     */
    public static Category toDomain(CategoryEntity entity) {
        if (entity == null) return null;
        Category category = new Category();
        category.setCategoryId(entity.getCategoryId());
        category.setCategoryName(entity.getCategoryName());
        category.setDescription(entity.getDescription());
        category.setPicture(entity.getPicture());
        return category;
    }

}
