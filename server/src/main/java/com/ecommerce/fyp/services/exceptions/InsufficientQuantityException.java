package com.ecommerce.fyp.services.exceptions;

import static java.lang.Math.abs;
import static java.lang.String.format;

public class InsufficientQuantityException extends Exception {

    public InsufficientQuantityException(int quantity) {
        super(format("Quantity %d not available in inventory", abs(quantity)));
    }
}
