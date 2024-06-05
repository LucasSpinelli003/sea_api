package br.com.fiap.seatech.dto.meet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record MeetRegisterDto(
        @NotNull
        LocalDate date,
        @NotBlank
        @Size(max = 100, min = 3, message = "max status size is 100 and min 3!")
        String local,
        @NotBlank
        @Size(max = 50, min = 3, message = "max status size is 50 and min 3!")
        String status) {}
