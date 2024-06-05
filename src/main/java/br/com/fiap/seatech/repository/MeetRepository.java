package br.com.fiap.seatech.repository;

import br.com.fiap.seatech.domain.Catch;
import br.com.fiap.seatech.domain.Meet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetRepository extends JpaRepository<Meet, Long> {}
