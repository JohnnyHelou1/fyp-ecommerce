package com.ecommerce.fyp.persistence.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Integer productID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> images;

    public Product() {

    }

    public Product(Integer productID, String name, String description, double price, List<ProductImage> images) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.images = images;

    }

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

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }
}
