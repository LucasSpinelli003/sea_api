package br.com.fiap.seatech.dto.meet;

import br.com.fiap.seatech.domain.Status;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record MeetUpdateDto(
                            @FutureOrPresent
                            LocalDate date,
                            @Size(max = 100, min = 5 , message = "Max size of local is 100 and min 5!")
                            String local,
                            Status status) {}
