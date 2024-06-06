package br.com.fiap.seatech.dto.meet;

import br.com.fiap.seatech.domain.Meet;
import br.com.fiap.seatech.domain.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record MeetDetailDto(Long id , LocalDate date,String local, Status status) {

    public MeetDetailDto(Meet meet){
        this(meet.getId(), meet.getDate(), meet.getLocal(), meet.getStatus());
    }
}
