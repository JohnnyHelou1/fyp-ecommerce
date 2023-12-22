package com.ecommerce.fyp.persistence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_IMAGE")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Image_ID")
    private Integer id;

    @Column(name = "Image")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public ProductImage() {

    }

    public ProductImage(byte[] image, Product product) {
        this.image = image;
        this.product = product;
    }

    public ProductImage(Integer id, byte[] image, Product product) {
        this.id = id;
        this.image = image;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
