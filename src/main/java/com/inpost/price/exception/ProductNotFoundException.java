package com.inpost.price.exception;


import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(UUID uuid) {
        super(String.format("Product not found: %s", uuid));
    }
}
