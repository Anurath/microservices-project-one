package com.ima.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException()
    {
        super("Use not found!!!");
    }

    public  ResourceNotFoundException(String message)
    {
        super(message);
    }
}
