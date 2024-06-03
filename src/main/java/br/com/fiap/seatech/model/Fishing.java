package br.com.fiap.seatech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Clob;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "tb_pescarias")
public class Fishing {

    @Id
    @GeneratedValue
    @Column(name = "cd_pescaria")
    private Long id;

    @Column(name = "dt_pescaria", nullable = false)
    private LocalDate date;

    @Column(name = "ds_localizacao",length = 300, nullable = false)
    private String localizacao;

    @Column(name = "ds_condicoes_climaticas", nullable = false)
    private Clob climateConditions;

    @Column(name = "tp_pesca",length = 50, nullable = false)
    private String fishing;

    @Column(name = "ds_metodo_pesca",length = 100, nullable = false)
    private String fishingMethod;

    @Column(name = "ds_detalhes", nullable = false)
    private String details;
}
