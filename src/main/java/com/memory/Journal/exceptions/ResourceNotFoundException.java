package com.memory.Journal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;

    public ResourceNotFoundException(String resourceName) {
        super(resourceName+ " not found");
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }
}
