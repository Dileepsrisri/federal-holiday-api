/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cgi.federalholidayapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author Dileep
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HolidayNotFoundException.class)
    public ResponseEntity<String> handleHolidayNotFound(HolidayNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<String> handleFileUploadException(FileUploadException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}