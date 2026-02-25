package com.product.product.exception;

import com.product.product.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<ExceptionDto> handleCategoryAlreadyExistException
            (CategoryAlreadyExistException ex, WebRequest webRequest){

        ExceptionDto exceptionDto = new ExceptionDto(webRequest.getDescription(false),
                HttpStatus.CONFLICT,
                ex.getMessage(),
                LocalDateTime.now() 
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDto);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleCategoryNotFoundException(CategoryNotFoundException ex,
                                                                        WebRequest webRequest){
        ExceptionDto exceptionDto = new ExceptionDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDto);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException ex,
                                                                       WebRequest webRequest) {
        ExceptionDto exceptionDto = new ExceptionDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDto);
    }

    @ExceptionHandler(ProductAlreadyExistException.class)
    public ResponseEntity<ExceptionDto> handleProductAlreadyExistException(ProductAlreadyExistException ex,
                                                                           WebRequest webRequest){
        ExceptionDto exceptionDto = new ExceptionDto(
                 webRequest.getDescription(false),
                HttpStatus.CONFLICT,
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(Exception ex, WebRequest webRequest){

        ExceptionDto exceptionDto  = new ExceptionDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }


}
