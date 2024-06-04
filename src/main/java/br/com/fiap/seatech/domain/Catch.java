package br.com.fiap.seatech.domain;

import br.com.fiap.seatech.dto.catchh.CatchRegisterDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
    @Table(name = "tb_capturas")
public class Catch {

    @Id
    @GeneratedValue
    @Column(name = "cd_captura")
    private Long id;

    @Column(name = "ds_quantidade", nullable = false)
    private Integer quantity;

    @Column(name = "ds_peso", nullable = false)
    private Double weight;

    @Column(name = "ds_foto")
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_pescaria", nullable = false)
    private Fishing fishing;


    public Catch(CatchRegisterDto dto, Fishing fishing) {
        quantity = dto.quantity();
        weight = dto.weigth();
        picture = dto.picture();
        this.fishing = fishing;
    }

}
