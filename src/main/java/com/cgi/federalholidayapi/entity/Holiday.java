package com.cgi.federalholidayapi.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;
import com.cgi.federalholidayapi.enums.Country;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

/**
 *
 * @author Dileep
 */
@Entity
@Table(name = "holidays")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Country country;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate date;
}
