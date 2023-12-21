package com.ecommerce.fyp.persistence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    public int productID;

    @Column(name = "Name")
    public String firstName;

    @Column(name = "lName")
    public String lastName;

    @Column(name = "Description")
    public String description;

    @Column(name = "price")
    public double price;

    @Column(name = "quantity")
    public int quantity;

    public Product(){

    }
    public Product(int productID, String firstName, String lastName,String description, double price, int quantity ){
        this.productID = productID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
