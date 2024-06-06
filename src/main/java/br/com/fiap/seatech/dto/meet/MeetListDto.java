package br.com.fiap.seatech.dto.meet;

import br.com.fiap.seatech.domain.Meet;
import br.com.fiap.seatech.domain.Status;
import br.com.fiap.seatech.dto.offer.OfferDetailDto;
import br.com.fiap.seatech.dto.user.UserDetailDto;

import java.time.LocalDate;
import java.util.List;

public record MeetListDto(Long id , LocalDate date, String local, Status status, List<UserDetailDto> users, List<OfferDetailDto> offers) {

    public MeetListDto(Meet meet){
        this(meet.getId(), meet.getDate(), meet.getLocal(), meet.getStatus(), meet.getUsers().stream().map(UserDetailDto::new).toList(), meet.getOffers().stream().map(OfferDetailDto::new).toList());
    }

}
