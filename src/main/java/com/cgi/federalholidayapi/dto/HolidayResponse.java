/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cgi.federalholidayapi.dto;

import com.cgi.federalholidayapi.enums.Country;
import java.time.LocalDate;
import lombok.*;

/**
 *
 * @author Dileep
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HolidayResponse {

    private Long id;

    private Country country;

    private String name;

    private LocalDate date;
}
