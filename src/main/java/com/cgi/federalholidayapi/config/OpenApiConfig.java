/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cgi.federalholidayapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Dileep
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI holidayOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Federal Holiday API")
                        .description("API to manage federal holidays for USA and Canada")
                        .version("1.0"));
    }
}
