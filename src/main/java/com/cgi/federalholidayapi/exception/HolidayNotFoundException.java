/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cgi.federalholidayapi.exception;

/**
 *
 * @author Dileep
 */
public class HolidayNotFoundException extends RuntimeException {

    public HolidayNotFoundException(String message) {
        super(message);
    }
}
