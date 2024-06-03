package br.com.fiap.seatech.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRegisterDto(
        @NotBlank
        @Size(max=150, min = 3, message = "Min name size is 3 and max 100!")
        String name,
        @NotBlank
        @Size(max=200, min = 13, message = "Min mail size is 13 and max 150!")
        String email,
        @NotBlank
        @Size(max=20, min = 6, message = "Min password size 6 and max 30!")
        String password,
        @NotBlank
        @Size(max = 10, min = 4, message = "Min type size is 4 and max 10!")
        String type,
        @NotNull
        String localization,
        @Size(max = 500, message = "Max size is 500")
        String avatar


) {}
