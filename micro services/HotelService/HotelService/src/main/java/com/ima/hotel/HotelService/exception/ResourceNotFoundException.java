package com.ima.hotel.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException()
    {
        super("Data not found");
    }

    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
