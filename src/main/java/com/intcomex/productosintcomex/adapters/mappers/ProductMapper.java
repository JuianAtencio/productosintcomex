package com.intcomex.productosintcomex.adapters.mappers;

import com.intcomex.productosintcomex.adapters.dto.ProductDTO;
import com.intcomex.productosintcomex.domain.Product;
import com.intcomex.productosintcomex.infrastructure.entity.ProductEntity;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        if (product == null) return null;
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setSupplierId(product.getSupplierId());
        dto.setCategoryId(product.getCategoryId());
        dto.setQuantityPerUnit(product.getQuantityPerUnit());
        dto.setUnitPrice(product.getUnitPrice());
        dto.setUnitsInStock(product.getUnitsInStock());
        dto.setUnitsOnOrder(product.getUnitsOnOrder());
        dto.setReorderLevel(product.getReorderLevel());
        dto.setDiscontinued(product.getDiscontinued());
        return dto;
    }

    public static Product toDomain(ProductDTO dto) {
        if (dto == null) return null;
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setSupplierId(dto.getSupplierId());
        product.setCategoryId(dto.getCategoryId());
        product.setQuantityPerUnit(dto.getQuantityPerUnit());
        product.setUnitPrice(dto.getUnitPrice());
        product.setUnitsInStock(dto.getUnitsInStock());
        product.setUnitsOnOrder(dto.getUnitsOnOrder());
        product.setReorderLevel(dto.getReorderLevel());
        product.setDiscontinued(dto.getDiscontinued());
        return product;
    }

    public static ProductEntity toEntity(Product product) {
        if (product == null) return null;
        ProductEntity entity = new ProductEntity();
        entity.setProductId(product.getProductId());
        entity.setProductName(product.getProductName());
        entity.setSupplierId(product.getSupplierId());
        entity.setCategoryId(product.getCategoryId());
        entity.setQuantityPerUnit(product.getQuantityPerUnit());
        entity.setUnitPrice(product.getUnitPrice());
        entity.setUnitsInStock(product.getUnitsInStock());
        entity.setUnitsOnOrder(product.getUnitsOnOrder());
        entity.setReorderLevel(product.getReorderLevel());
        entity.setDiscontinued(product.getDiscontinued());
        return entity;
    }

    public static Product toDomain(ProductEntity entity) {
        if (entity == null) return null;
        Product product = new Product();
        product.setProductId(entity.getProductId());
        product.setProductName(entity.getProductName());
        product.setSupplierId(entity.getSupplierId());
        product.setCategoryId(entity.getCategoryId());
        product.setQuantityPerUnit(entity.getQuantityPerUnit());
        product.setUnitPrice(entity.getUnitPrice());
        product.setUnitsInStock(entity.getUnitsInStock());
        product.setUnitsOnOrder(entity.getUnitsOnOrder());
        product.setReorderLevel(entity.getReorderLevel());
        product.setDiscontinued(entity.getDiscontinued());
        return product;
    }
}
