package com.leonardo.Spring.error;

import java.time.Instant;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Error {

    // Atributes
    // Status
    private Integer status;

    // Message
    private String message;

    // Time Stamp
    private Long timestamp;

    // Path
    private String path;

    // Error Fields Validation
    private HashMap<String, String> errorFieldsValidation;

    // Constructors
    // Empty
    public Error() {
    }

    // Full
    public Error(Integer status, String message, String path) {
        this.status = status;
        this.message = message;
        this.timestamp = Instant.now().toEpochMilli();
        this.path = path;
    }

    // Getters and Setters
    // Status
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    // Message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Time Stamp
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    // Path
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // Error Fields Validation
    public HashMap<String, String> getErrorFieldsValidation() {
        return errorFieldsValidation;
    }

    public void setErrorFieldsValidation(HashMap<String, String> errorFieldsValidation) {
        this.errorFieldsValidation = errorFieldsValidation;
    }
}
