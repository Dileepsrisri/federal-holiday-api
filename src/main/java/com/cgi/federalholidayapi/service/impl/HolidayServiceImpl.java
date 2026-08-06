/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cgi.federalholidayapi.service.impl;

import com.cgi.federalholidayapi.dto.HolidayRequest;
import com.cgi.federalholidayapi.dto.HolidayResponse;
import com.cgi.federalholidayapi.entity.Holiday;
import com.cgi.federalholidayapi.exception.HolidayNotFoundException;
import com.cgi.federalholidayapi.repository.HolidayRepository;
import com.cgi.federalholidayapi.service.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.cgi.federalholidayapi.enums.Country;
import com.cgi.federalholidayapi.exception.FileUploadException;
import com.cgi.federalholidayapi.exception.DuplicateHolidayException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dileep
 */
@Service
@RequiredArgsConstructor
public class HolidayServiceImpl implements HolidayService {

    private final HolidayRepository holidayRepository;

    @Override
    public HolidayResponse addHoliday(HolidayRequest request) {
        if (holidayRepository.existsByCountryAndNameAndDate(request.getCountry(),request.getName(),request.getDate())) {
            throw new DuplicateHolidayException("Holiday already exists for the given country, name and date" );
        }
        Holiday holiday = Holiday.builder()
                .country(request.getCountry())
                .name(request.getName())
                .date(request.getDate())
                .build();
        Holiday savedHoliday = holidayRepository.save(holiday);
        return mapToResponse(savedHoliday);
    }

    @Override
    public List<HolidayResponse> getAllHolidays() {
        List<Holiday> holidays = holidayRepository.findAll();
        return holidays.stream().map(this::mapToResponse).toList();
    }

    @Override
    public List<HolidayResponse> getHolidaysByCountry(Country country) {
        List<Holiday> holidays = holidayRepository.findByCountry(country);
        return holidays.stream().map(this::mapToResponse).toList();
    }

    @Override
    public HolidayResponse updateHoliday(Long id, HolidayRequest request) {
        Holiday holiday = holidayRepository.findById(id)
                .orElseThrow(()
                        -> new HolidayNotFoundException("Holiday not found with id: " + id)
                );
        holiday.setCountry(request.getCountry());
        holiday.setName(request.getName());
        holiday.setDate(request.getDate());
        Holiday updatedHoliday = holidayRepository.save(holiday);
        return mapToResponse(updatedHoliday);
    }

    @Override
    @Transactional
    public int uploadHolidays(MultipartFile file) {
        List<Holiday> holidays = new ArrayList<>();
        if (file == null || file.isEmpty()) {
            throw new FileUploadException("Uploaded file is empty");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Holiday holiday = Holiday.builder()
                        .country(Country.valueOf(data[0].trim().toUpperCase()))
                        .name(data[1].trim())
                        .date(LocalDate.parse(data[2].trim()))
                        .build();
                holidays.add(holiday);
            }
            
            holidayRepository.saveAll(holidays);
            return holidays.size();
        } catch (IOException e) {
            throw new FileUploadException("Failed to read file", e);
        }
    }

    @Override
    public void deleteHoliday(Long id) {
        Holiday holiday = holidayRepository.findById(id)
                .orElseThrow(()
                        -> new HolidayNotFoundException(
                        "Holiday not found with id: " + id
                ));
        holidayRepository.delete(holiday);
    }

    private HolidayResponse mapToResponse(Holiday holiday) {
        return HolidayResponse.builder()
                .id(holiday.getId())
                .country(holiday.getCountry())
                .name(holiday.getName())
                .date(holiday.getDate())
                .build();
    }
}
