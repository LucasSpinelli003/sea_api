package br.com.fiap.seatech.dto.user;

import br.com.fiap.seatech.domain.User;

public record UserDetailDto (Long id, String name, String email, String password, String type, String localization, String avatar) {

    public UserDetailDto(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getType(), user.getLocalization(),user.getAvatar());
    }
}
