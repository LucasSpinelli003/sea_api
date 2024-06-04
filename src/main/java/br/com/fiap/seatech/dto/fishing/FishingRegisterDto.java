package br.com.fiap.seatech.dto.fishing;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Clob;
import java.time.LocalDate;


public record FishingRegisterDto(
        @NotNull
        LocalDate date,
        @NotNull
        String climateConditions,
        @NotBlank
        @Size(max =300, min =5 , message = "Max localization size is 300 and min 5 !")
        String localization,
        @NotBlank
        @Size(max =50, min =3 , message = "Max localization size is 300 and min 5 !")
        String fishing,
        @NotBlank
        @Size(max = 100, min =5 , message = "Max fishing method size is and min !")
        String fishingMethod,
        @NotBlank
        String details
) {}

