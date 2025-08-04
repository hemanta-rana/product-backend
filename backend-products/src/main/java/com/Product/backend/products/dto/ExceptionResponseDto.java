package com.Product.backend.products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDto {

    private String apiPath;
    private int statusCode;
    private String errorMessage;
    private LocalDateTime errorTime;

    public ExceptionResponseDto(String apiPath, HttpStatus status, String errorMessage, LocalDateTime errorTime) {
        this.apiPath = apiPath;
        this.statusCode = status.value();  // store numeric status code
        this.errorMessage = errorMessage;
        this.errorTime = errorTime;
    }

}
