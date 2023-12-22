package com.ecommerce.fyp.persistence.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    private Integer id;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> items;

    public  Cart() {

    }

    public Cart(Integer id, List<CartItem> items) {
        this.id = id;
        this.items = items;
    }

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
