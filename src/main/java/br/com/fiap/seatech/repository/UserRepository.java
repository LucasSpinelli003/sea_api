package br.com.fiap.seatech.repository;

import br.com.fiap.seatech.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User u where u.email like %:email%")
    User searchByEmail(@Param("email") String email);

}
