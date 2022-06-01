package com.webserver.webserver.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Recurso não encontrado. ID: " + id);
    }
}
