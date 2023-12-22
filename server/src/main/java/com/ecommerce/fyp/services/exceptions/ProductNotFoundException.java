package com.ecommerce.fyp.services.exceptions;

import static java.lang.String.format;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(int productId) {
        super(format("Product %d not found", productId));
    }
}