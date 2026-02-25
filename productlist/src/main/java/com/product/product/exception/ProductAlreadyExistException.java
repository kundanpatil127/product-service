package com.product.product.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ProductAlreadyExistException extends  RuntimeException{

    public ProductAlreadyExistException(String message){
        super(message);
    }
}
