package br.com.fiap.seatech.dto.user;

import br.com.fiap.seatech.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDetailDto (Long id, String name, String mail, String password, String type, String localization, String avatar) {

    public UserDetailDto(User user){
        this(user.getId(), user.getName(), user.getMail(), user.getPassword(), user.getType(), user.getLocalization(),user.getAvatar());
    }
}
