package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class NotFountException extends BookingException{
    private static final long serialVersionUID = 1L;

    public NotFountException(String message, String code) {
        super(message, HttpStatus.NOT_FOUND.value(), code);
    }

    public NotFountException(String message, String code, ErrorDto data) {
        super(message, HttpStatus.NOT_FOUND.value(), code, Arrays.asList(data));
    }
}
