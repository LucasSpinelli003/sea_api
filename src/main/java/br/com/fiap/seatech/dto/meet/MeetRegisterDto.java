package br.com.fiap.seatech.dto.meet;

import br.com.fiap.seatech.domain.Status;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record MeetRegisterDto(
        @NotNull
        @FutureOrPresent
        LocalDate date,
        @NotBlank
        @Size(max = 100, min = 5, message = "max status size is 100 and min 3!")
        String local,
        @NotNull
        Status status) {}
