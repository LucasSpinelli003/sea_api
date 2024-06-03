package br.com.fiap.seatech.repository;

import br.com.fiap.seatech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
