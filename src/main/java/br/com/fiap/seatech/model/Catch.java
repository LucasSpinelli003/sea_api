package br.com.fiap.seatech.model;

import ch.qos.logback.core.model.NamedModel;
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
    @Column(name = "cd_especie")
    private Long id;

    @Column(name = "ds_quantidade", nullable = false)
    private Integer quantity;

    @Column(name = "ds_peso", nullable = false)
    private Double weight;

    @Column(name = "ds_foto")
    private String picture;

}
