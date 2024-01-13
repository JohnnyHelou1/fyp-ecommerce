package com.ecommerce.fyp.services.exceptions;

import static java.lang.String.format;

public class CategoryNotFoundException extends  Exception{
    public CategoryNotFoundException (String category){
        super(format("Category %d not found", category));
    }

}

