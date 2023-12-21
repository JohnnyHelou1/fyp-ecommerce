package com.ecommerce.fyp.services.exceptions;

import static java.lang.String.format;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(int userId) {
        super(format("User %d not found", userId));
    }
}
