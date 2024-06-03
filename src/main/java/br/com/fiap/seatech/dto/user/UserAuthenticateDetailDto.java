package br.com.fiap.seatech.dto.user;

import br.com.fiap.seatech.model.User;

public record UserAuthenticateDetailDto(Long id, String name, String email, String password, String localization, String avatar ) {

    public UserAuthenticateDetailDto(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getType(), user.getLocalization(), user.getAvatar());
    }

}
