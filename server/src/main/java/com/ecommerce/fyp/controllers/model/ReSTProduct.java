package com.ecommerce.fyp.controllers.model;

import com.ecommerce.fyp.persistence.model.ProductImage;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.List;

public class ReSTProduct {
    private Integer productID;
    private String name;
    private String description;
    private double price;
    private String category;
    private boolean isFeatured;
    private List<ReSTProductImage> images;

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ReSTProductImage> getImages() {
        return images;
    }

    public void setImages(List<ReSTProductImage> images) {
        this.images = images;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }
}
