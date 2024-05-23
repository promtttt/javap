package com.example.integratedsj2.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class ExceptionResponse {
    private final ZonedDateTime timestamp;
    private final Integer status;
    private final String message;
    private final String instance;
}
