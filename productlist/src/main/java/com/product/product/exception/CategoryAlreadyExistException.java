package com.product.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlreadyExistException extends RuntimeException{

    //main class
    public CategoryAlreadyExistException(String message){
        super(message);
    }
}
