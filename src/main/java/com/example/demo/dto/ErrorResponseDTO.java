package com.example.demo.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDTO(LocalDateTime timestamp, HttpStatus status , String message, String details) {
}
