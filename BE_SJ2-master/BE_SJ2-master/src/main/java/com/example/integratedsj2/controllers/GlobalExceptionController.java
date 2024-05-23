package com.example.integratedsj2.controllers;

import com.example.integratedsj2.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionResponse> exceptionResponse(WebRequest webRequest){
        return buildErrorResponse(HttpStatus.NOT_FOUND, getRequestPath(webRequest));
    }

    public ResponseEntity<ExceptionResponse> buildErrorResponse(HttpStatus httpStatus, String instance){
        return new ResponseEntity<>(
                new ExceptionResponse(ZonedDateTime.now(), httpStatus.value(), "NOT FOUND", instance), httpStatus);
    }
    private String getRequestPath(WebRequest request) {
        return request.getDescription(false).replace("uri=", "");
    }
}
