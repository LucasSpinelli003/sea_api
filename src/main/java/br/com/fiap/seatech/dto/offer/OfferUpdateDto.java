package br.com.fiap.seatech.dto.offer;

import br.com.fiap.seatech.domain.Status;
import jakarta.validation.constraints.Size;

public record OfferUpdateDto(
        @Size(max = 100, min = 3, message = "max species size is 100 and min 3")
        String species,
        Integer amount,
        Double price,
        Status status

) {}
