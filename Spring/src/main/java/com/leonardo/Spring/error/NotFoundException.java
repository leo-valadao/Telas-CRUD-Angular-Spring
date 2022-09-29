package com.leonardo.Spring.error;

public class NotFoundException extends RuntimeException {

    // Attributes
    private String message;

    // Constructor
    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
