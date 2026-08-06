/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cgi.federalholidayapi.controller;

import com.cgi.federalholidayapi.dto.HolidayRequest;
import com.cgi.federalholidayapi.dto.HolidayResponse;
import com.cgi.federalholidayapi.enums.Country;
import com.cgi.federalholidayapi.service.HolidayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Dileep
 */
@RestController
@RequestMapping("/api/holidays")
@RequiredArgsConstructor
@Tag(
        name = "Federal Holiday Management",
        description = "APIs to add, update and list federal holidays"
)
public class HolidayController {

    private final HolidayService holidayService;

    @Operation(
            summary = "Add a federal holiday",
            description = "Creates a new federal holiday for USA or Canada"
    )
    @PostMapping
    public HolidayResponse addHoliday(@Valid @RequestBody HolidayRequest request) {
        return holidayService.addHoliday(request);
    }

    @Operation(
            summary = "List all federal holidays"
    )
    @GetMapping
    public List<HolidayResponse> getAllHolidays() {
        return holidayService.getAllHolidays();
    }

    @Operation(
            summary = "List holidays by country",
            description = "Returns holidays for USA or CANADA"
    )
    @GetMapping("/country/{country}")
    public List<HolidayResponse> getHolidaysByCountry(@PathVariable Country country) {
        return holidayService.getHolidaysByCountry(country);
    }

    @Operation(
            summary = "Update an existing holiday"
    )
    @PutMapping("/{id}")
    public HolidayResponse updateHoliday(@PathVariable Long id, @Valid @RequestBody HolidayRequest request) {
        return holidayService.updateHoliday(id, request);
    }

    @Operation(
            summary = "Upload holiday CSV file",
            description = "Uploads multiple federal holidays from a CSV file"
    )
    @PostMapping("/upload")
    public ResponseEntity<String> uploadHolidayFile(@RequestParam("file") MultipartFile file) {
        int count = holidayService.uploadHolidays(file);
        return ResponseEntity.ok(count + " holidays uploaded successfully.");
    }

    @Operation(
            summary = "Delete a federal holiday",
            description = "Deletes a holiday using the provided holiday ID"
    )
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Holiday deleted successfully"
        ),
        @ApiResponse(
                responseCode = "404",
                description = "Holiday not found"
        )
    })
    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable Long id) {
        holidayService.deleteHoliday(id);
    }
}
