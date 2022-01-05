package com.kentratech.kentrastockorder.service.exceptions;

import com.kentratech.kentrastockorder.entity.Provider;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id + ", Type: " + Provider.class.getName());
    }
}
