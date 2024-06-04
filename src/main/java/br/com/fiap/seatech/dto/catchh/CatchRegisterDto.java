package br.com.fiap.seatech.dto.catchh;


import jakarta.validation.constraints.NotNull;

public record CatchRegisterDto(
        @NotNull
        Integer quantity,
        @NotNull
        Double weigth,
        String picture) {
}
