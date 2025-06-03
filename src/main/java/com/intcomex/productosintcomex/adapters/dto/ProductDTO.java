package com.intcomex.productosintcomex.adapters.dto;

public class ProductDTO {

    private Integer productId;
    private String productName;
    private Integer supplierId;
    private Integer categoryId;
    private String quantityPerUnit;
    private Double unitPrice;
    private Short unitsInStock;
    private Short unitsOnOrder;
    private Short reorderLevel;
    private Boolean discontinued;

    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }
    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }
    public Double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Short getUnitsInStock() {
        return unitsInStock;
    }
    public void setUnitsInStock(Short unitsInStock) {
        this.unitsInStock = unitsInStock;
    }
    public Short getUnitsOnOrder() {
        return unitsOnOrder;
    }
    public void setUnitsOnOrder(Short unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }
    public Short getReorderLevel() {
        return reorderLevel;
    }
    public void setReorderLevel(Short reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
    public Boolean getDiscontinued() {
        return discontinued;
    }
    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }
 
}
