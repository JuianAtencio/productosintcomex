package com.intcomex.productosintcomex.domain;

public class Category {

    private Integer categoryId;
    private String categoryName;
    private String description;
    private String picture;
    
    public Integer getCategoryId() {
        return categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public String getDescription() {
        return description;
    }
    public String getPicture() {
        return picture;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

}
