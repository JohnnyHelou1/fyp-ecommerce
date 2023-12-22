package com.ecommerce.fyp.controllers.model;

import java.util.List;

public class ReSTCart {
    private final Integer id;
    private final List<ReSTCartItem> items;

    public ReSTCart(Integer id, List<ReSTCartItem> items) {
        this.id = id;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public List<ReSTCartItem> getItems() {
        return items;
    }
}