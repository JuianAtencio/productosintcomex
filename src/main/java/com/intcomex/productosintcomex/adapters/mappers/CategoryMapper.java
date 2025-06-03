package com.intcomex.productosintcomex.adapters.mappers;

import com.intcomex.productosintcomex.domain.Category;
import com.intcomex.productosintcomex.infrastructure.entity.CategoryEntity;
import com.intcomex.productosintcomex.adapters.dto.CategoryDTO;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category category) {
        if (category == null) return null;
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        dto.setDescription(category.getDescription());
        dto.setPicture(category.getPicture());
        return dto;
    }

    public static Category toDomain(CategoryDTO dto) {
        if (dto == null) return null;
        Category category = new Category();
        category.setCategoryId(dto.getCategoryId());
        category.setCategoryName(dto.getCategoryName());
        category.setDescription(dto.getDescription());
        category.setPicture(dto.getPicture());
        return category;
    }

    public static CategoryEntity toEntity(Category category) {
        if (category == null) return null;
        CategoryEntity entity = new CategoryEntity();
        entity.setCategoryId(category.getCategoryId());
        entity.setCategoryName(category.getCategoryName());
        entity.setDescription(category.getDescription());
        entity.setPicture(category.getPicture());
        return entity;
    }

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
