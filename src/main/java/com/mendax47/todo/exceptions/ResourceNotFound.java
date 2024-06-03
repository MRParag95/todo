package com.mendax47.todo.exceptions;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String resourceName) {
        super(resourceName + " not found.");
    }
}