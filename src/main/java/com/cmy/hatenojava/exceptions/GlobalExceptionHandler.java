package com.cmy.hatenojava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.exceptions
 * @className: GlobalExceptionHandler
 * @author: Terry Cai
 * @description: Handles all the exceptions
 * @date: 2/28/24 8:23 PM
 * @version: 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // Example handling of a custom exception
    @ExceptionHandler(ResponseException.class)
    protected ResponseEntity<Object> handleUserAlreadyExists(
            ResponseException ex, WebRequest request) {
        // Build your error response here
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Additional exception handlers as needed...
}
