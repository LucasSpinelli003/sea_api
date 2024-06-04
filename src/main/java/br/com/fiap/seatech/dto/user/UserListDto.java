package br.com.fiap.seatech.dto.user;

import br.com.fiap.seatech.domain.User;
import br.com.fiap.seatech.dto.fishing.FishingDetailDto;

import java.util.List;

public record UserListDto(Long id, String name, String email, String password, String type, String localization, String avatar, List<FishingDetailDto> fishings) {
    public UserListDto(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getType(), user.getLocalization(), user.getAvatar(),
                user.getFishings().stream().map(FishingDetailDto::new).toList());
    }

}
