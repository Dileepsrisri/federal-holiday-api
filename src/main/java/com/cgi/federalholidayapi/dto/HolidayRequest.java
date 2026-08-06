/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cgi.federalholidayapi.dto;

import com.cgi.federalholidayapi.enums.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class HolidayRequest {

    @NotNull(message = "Country is required")
    private Country country;

    @NotBlank(message = "Holiday name is required")
    private String name;

    @NotNull(message = "Holiday date is required")
    private LocalDate date;
}
