package com.inpost.price.exception;


public class NoDiscountException extends RuntimeException {

    public NoDiscountException() {
        super("No discount type set");
    }
}
