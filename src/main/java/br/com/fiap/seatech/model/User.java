package br.com.fiap.seatech.model;

import br.com.fiap.seatech.dto.user.UserRegisterDto;
import br.com.fiap.seatech.dto.user.UserUpdateDto;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "tb_usuario")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "cd_usuario")
    private Long id;

    @Column(name = "nm_usuario" ,length = 1500, nullable = false)
    private String name;

    @Column(name = "ds_email", length = 200, unique = true ,nullable = false)
    private String email;

    @Column(name="ds_senha",length = 20, nullable = false)
    private String password;

    @Column(name="ds_tipo", length = 10, nullable = false)
    private String type;

    @Column(name = "ds_localizacao", nullable = false)
    private String localization;

    @Column(name = "ds_foto_perfil", nullable = false)
    private String avatar;

    public User(UserRegisterDto dto) {
        name = dto.name();
        email = dto.email();
        password = dto.password();
        type = dto.type();
        localization = dto.localization();
        avatar = dto.avatar();
    }


    public void updateData(UserUpdateDto dto) {
        if(dto.name() != null){
            name = dto.name();
        }
        if(dto.email() != null){
            email = dto.email();
        }
        if(dto.password() != null){
            password = dto.password();
        }
        if(dto.type() != null){
            type = dto.type();
        }
        if(dto.localization() != null){
            localization = dto.localization();
        }
        if(dto.avatar() != null){
            avatar = dto.avatar();
        }
    }
}
