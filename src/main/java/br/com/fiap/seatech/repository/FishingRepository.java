package br.com.fiap.seatech.repository;

import br.com.fiap.seatech.domain.Fishing;
import br.com.fiap.seatech.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FishingRepository extends JpaRepository<Fishing, Long> {}
