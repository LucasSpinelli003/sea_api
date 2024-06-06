package br.com.fiap.seatech.dto.offer;

import br.com.fiap.seatech.domain.Offer;
import br.com.fiap.seatech.domain.Status;

public record OfferListDto(Long id, String species, Integer amount, Double price, Status status) {
    public OfferListDto(Offer offer){
        this(offer.getId(), offer.getSpecies(), offer.getAmount(), offer.getPrice(), offer.getStatus());
    }

}
