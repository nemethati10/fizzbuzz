package com.ibm.fizzbuzz.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.ibm.fizzbuzz.entity.FizzBuzzBE;

/**
 * Global exception handler.
 */
@ControllerAdvice
public class GlobalExceptionController {

    private static final String INVALID_PATH_VARIABLE =
            "Invalid request, n must be a positive number and must be bigger than 0!";

    private static final String INVALID_REQUEST_METHOD = "Invalid request method, GET request is needed!";

    /**
     * Handles the {@link HttpRequestMethodNotSupportedException} and {@link MethodArgumentTypeMismatchException}
     *
     * @param exception
     *
     * @return FizzBuzz entity with error response
     */
    @ExceptionHandler({ HttpRequestMethodNotSupportedException.class, MethodArgumentTypeMismatchException.class })
    public ResponseEntity<FizzBuzzBE> handleException(final Exception exception) {
        final FizzBuzzBE fizzBuzz = new FizzBuzzBE();
        if (exception instanceof HttpRequestMethodNotSupportedException) {
            fizzBuzz.setMessage(INVALID_REQUEST_METHOD);
            return new ResponseEntity<>(fizzBuzz, HttpStatus.METHOD_NOT_ALLOWED);
        } fizzBuzz.setMessage(INVALID_PATH_VARIABLE);
        return new ResponseEntity<>(fizzBuzz, HttpStatus.BAD_REQUEST);
    }

}
