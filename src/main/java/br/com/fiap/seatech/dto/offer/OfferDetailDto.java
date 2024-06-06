package br.com.fiap.seatech.dto.offer;

import br.com.fiap.seatech.domain.Meet;
import br.com.fiap.seatech.domain.Offer;
import br.com.fiap.seatech.domain.Status;

import java.time.LocalDate;

public record OfferDetailDto(Long id , String species, Integer amount, Double price , Status status) {

    public OfferDetailDto(Offer offer){
        this(offer.getId(), offer.getSpecies(), offer.getAmount(), offer.getPrice(),offer.getStatus());
    }
}
