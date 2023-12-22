package com.ecommerce.fyp.controllers;

import com.ecommerce.fyp.controllers.model.ReSTCart;
import com.ecommerce.fyp.controllers.model.ReSTCartItem;
import com.ecommerce.fyp.persistence.model.Cart;
import com.ecommerce.fyp.persistence.model.CartItem;
import com.ecommerce.fyp.services.CartService;
import com.ecommerce.fyp.services.exceptions.CartNotFoundException;
import com.ecommerce.fyp.services.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/ecommerce/cart")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping
    public ReSTCart createCart() {
        return toReSTCart(cartService.createCart());
    }

    @GetMapping(value = "/{id}")
    public ReSTCart getCart(@PathVariable("id") int cartId) throws CartNotFoundException {
        return toReSTCart(cartService.getCart(cartId));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable("id") int cartId) throws CartNotFoundException {
        cartService.deleteCart(cartId);
    }

    @PutMapping(value = "/{id}/products/{product-id}/{quantity}")
    public void addToCart(@PathVariable("id") int cartId, @PathVariable("product-id") int productId, @PathVariable("quantity") int quantity) throws ProductNotFoundException, CartNotFoundException {
        cartService.addToCart(cartId, productId, quantity);
    }

    @DeleteMapping(value = "/{id}/products/{product-id}")
    public void removeFromCart(@PathVariable("id") int cartId, @PathVariable("product-id") int productId) throws ProductNotFoundException, CartNotFoundException {
        cartService.removeFromCart(cartId, productId);
    }

    private ReSTCart toReSTCart(Cart cart) {
        List<ReSTCartItem> restCartItems = sanitizeCartItems(cart.getItems()).stream()
                .map(this::toReSTCartItem)
                .collect(Collectors.toList());
        return new ReSTCart(cart.getId(), restCartItems);
    }

    private ReSTCartItem toReSTCartItem(CartItem item) {
        return new ReSTCartItem(item.getId(), item.getCart().getId(), item.getProduct().getProductID(), item.getQuantity());
    }

    private List<CartItem> sanitizeCartItems(List<CartItem> items) {
        if (items == null) {
            return new ArrayList<>();
        }

        return items;
    }
}
