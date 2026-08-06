/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cgi.federalholidayapi.repository;

import com.cgi.federalholidayapi.entity.Holiday;
import com.cgi.federalholidayapi.enums.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

import java.util.List;

/**
 *
 * @author Dileep
 */
@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {

    List<Holiday> findByCountry(Country country);
    
    boolean existsByCountryAndNameAndDate(Country country, String name, LocalDate date);
}
