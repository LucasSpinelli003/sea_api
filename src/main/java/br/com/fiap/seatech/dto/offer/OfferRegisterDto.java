package br.com.fiap.seatech.dto.offer;

import br.com.fiap.seatech.domain.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record OfferRegisterDto(
        @NotBlank
        @Size(max = 100, min = 3, message = "max status size is 100 and min 3!")
        String species,
        @NotNull
        Integer amount,
        @NotNull
        Double price,
        @NotNull
        Status status
        ) {}
