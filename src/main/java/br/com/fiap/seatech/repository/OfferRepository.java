package br.com.fiap.seatech.repository;

import br.com.fiap.seatech.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {}
