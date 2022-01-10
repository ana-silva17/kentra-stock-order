package com.kentratech.kentrastockorder.service.exceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String error) {

        super(error);
    }

    public BadRequestException(String message, Throwable cause){

        super(message, cause);
    }
}
