package br.com.fiap.seatech.dto.user;

import jakarta.validation.constraints.NotBlank;

public record UserValidationDto(
        @NotBlank
        String email,
        @NotBlank
        String password
) {}
