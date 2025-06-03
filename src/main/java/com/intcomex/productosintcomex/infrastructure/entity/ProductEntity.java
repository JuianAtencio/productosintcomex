package com.intcomex.productosintcomex.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Integer productId;

    @Column(name = "productname")
    private String productName;

    @Column(name = "supplierid")
    private Integer supplierId;

    @Column(name = "categoryid")
    private Integer categoryId;

    @Column(name = "quantityperunit")
    private String quantityPerUnit;

    @Column(name = "unitprice")
    private Double unitPrice;

    @Column(name = "unitsinstock")
    private Short unitsInStock;

    @Column(name = "unitsonorder")
    private Short unitsOnOrder;

    @Column(name = "reorderlevel")
    private Short reorderLevel;

    @Column(name = "discontinued")
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
