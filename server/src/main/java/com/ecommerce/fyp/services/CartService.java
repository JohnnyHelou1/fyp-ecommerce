package com.ecommerce.fyp.services;

import com.ecommerce.fyp.persistence.model.Cart;
import com.ecommerce.fyp.persistence.model.CartItem;
import com.ecommerce.fyp.persistence.model.Product;
import com.ecommerce.fyp.persistence.repositories.CartItemRepository;
import com.ecommerce.fyp.persistence.repositories.CartRepository;
import com.ecommerce.fyp.persistence.repositories.InventoryRepository;
import com.ecommerce.fyp.persistence.repositories.ProductRepository;
import com.ecommerce.fyp.services.exceptions.CartNotFoundException;
import com.ecommerce.fyp.services.exceptions.ProductNotFoundException;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final InventoryRepository inventoryRepository;

    public CartService(CartRepository repository, ProductRepository productRepository, CartItemRepository cartItemRepository, InventoryRepository inventoryRepository) {
        this.cartRepository = repository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public Cart createCart() {
        return cartRepository.saveAndFlush(new Cart());
    }

    public Cart getCart(int id) throws CartNotFoundException {
        return cartRepository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
    }

    public void deleteCart(int id) throws CartNotFoundException {
        Cart cart = cartRepository.findById(id)
                        .orElseThrow(() -> new CartNotFoundException(id));
        cart.getItems().forEach(item -> cartItemRepository.deleteById(item.getId()));
        cartRepository.deleteById(id);
    }

    public void addToCart(int cartId, int productId, int quantity) throws CartNotFoundException, ProductNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        Optional<CartItem> cartItemOptional = cart.getItems().stream()
                .filter(item -> item.getProduct().getProductID() == productId)
                .findFirst();

        if (cartItemOptional.isPresent()) {
            CartItem cartItem = cartItemOptional.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItemRepository.saveAndFlush(cartItem);
        } else {
            CartItem cartItem = new CartItem(cart, product, quantity);
            cartItemRepository.saveAndFlush(cartItem);
        }
    }

    public void removeFromCart(int cartId, int productId) throws CartNotFoundException, ProductNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        cart.getItems().stream()
                .filter(item -> item.getProduct().getProductID() == productId)
                .findFirst()
                .ifPresent(item -> cartItemRepository.deleteById(item.getId()));
    }
}
