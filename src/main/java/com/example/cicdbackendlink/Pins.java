package com.example.cicdbackendlink;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    private String sheepId;
    @DecimalMin(value = "-90.0",message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0",message = "Latitude must be between -90 and 90")
    private double latitude;

    @DecimalMin(value = "-180.0",message = "Latitude must be between -180 and 180")
    @DecimalMax(value = "180.0",message = "Latitude must be between -180 and 180")
    private double longitude;

    @PastOrPresent
    private LocalDate date;
}
