/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cgi.federalholidayapi.service;

import com.cgi.federalholidayapi.dto.HolidayRequest;
import com.cgi.federalholidayapi.dto.HolidayResponse;
import com.cgi.federalholidayapi.enums.Country;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author Dileep
 */
public interface HolidayService {

    HolidayResponse addHoliday(HolidayRequest request);

    List<HolidayResponse> getAllHolidays();

    List<HolidayResponse> getHolidaysByCountry(Country country);

    HolidayResponse updateHoliday(Long id, HolidayRequest request);

    void deleteHoliday(Long id);
    
    int uploadHolidays(MultipartFile file);
}
