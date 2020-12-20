package com.gildedrose.exceptions;

public class ItemValidationException extends RuntimeException{
    public ItemValidationException(String message) {
        super(message);
    }
}
