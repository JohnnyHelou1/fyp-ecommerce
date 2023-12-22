package com.ecommerce.fyp.controllers.model;

public class ReSTCartItem {
    private final Integer id;
    private final int cartId;
    private final int productId;
    private final int quantity;

    public ReSTCartItem(Integer id, int cartId, int productId, int quantity) {
        this.id = id;
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public int getCartId() {
        return cartId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
