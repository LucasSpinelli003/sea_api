package br.com.fiap.seatech.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserValidation(
        @NotBlank
        String email,
        @NotBlank
        String password
) {}
