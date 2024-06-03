package br.com.fiap.seatech.dto.user;

import br.com.fiap.seatech.model.User;

public record UserListDto(Long id, String name, String mail, String password, String type, String localization, String avatar) {
    public UserListDto(User user){
        this(user.getId(), user.getName(), user.getMail(), user.getPassword(), user.getType(), user.getLocalization(), user.getAvatar());
    }

}
