package com.ecommerce.fyp.services.exceptions;

import static java.lang.String.format;

public class CartNotFoundException extends Exception {

    public CartNotFoundException(int cartId) {
        super(format("Cart %d not found", cartId));
    }
}
