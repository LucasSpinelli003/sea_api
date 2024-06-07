package br.com.fiap.seatech.dto.catchh;

import jakarta.validation.constraints.NotNull;

public record CatchUpdateDto(
        Integer quantity,
        Double weigth,
        String picture) {
}
