package br.com.fiap.seatech.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserValidation(
        @NotBlank
        @Size(max = 200, min = 10, message = "Max mail size is 200 and min 10.")
        String mail,
        @NotBlank
        @Size(max = 20, min = 6, message = "Max password size is 20 and min 6.")
        String password
) {}
