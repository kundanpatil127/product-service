package com.product.product.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionDto {

    private String apiPath;
    private HttpStatus statusCode;
    private String description;
    private LocalDateTime errorDateTime;

    public ExceptionDto(String apiPath, HttpStatus statusCode, String description, LocalDateTime errorDateTime) {
        this.apiPath = apiPath;
        this.statusCode = statusCode;
        this.description = description;
        this.errorDateTime = errorDateTime;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getErrorDateTime() {
        return errorDateTime;
    }

    public void setErrorDateTime(LocalDateTime errorDateTime) {
        this.errorDateTime = errorDateTime;
    }
}
