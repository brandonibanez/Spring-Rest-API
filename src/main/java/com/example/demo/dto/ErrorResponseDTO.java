package com.example.demo.dto;

import org.springframework.http.HttpStatus;

public class ErrorResponseDTO {

    private HttpStatus statusCode;
    private String message;

    public ErrorResponseDTO(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponseDTO{" +
                "statusCode='" + statusCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
