package br.com.fiap.seatech.dto.user;

import br.com.fiap.seatech.domain.User;
import br.com.fiap.seatech.dto.fishing.FishingDetailDto;
import br.com.fiap.seatech.dto.meet.MeetDetailDto;

import java.util.List;
import java.util.Set;

public record UserListDto(Long id, String name, String email, String password, String type, String localization, String avatar, List<FishingDetailDto> fishings, List<MeetDetailDto> meets) {
    public UserListDto(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getType(), user.getLocalization(), user.getAvatar(),
                user.getFishings().stream().map(FishingDetailDto::new).toList(), user.getMeets().stream().map(MeetDetailDto::new).toList());
    }

}
