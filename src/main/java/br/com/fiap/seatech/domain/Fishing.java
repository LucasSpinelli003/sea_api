package br.com.fiap.seatech.domain;

import br.com.fiap.seatech.dto.fishing.FishingRegisterDto;
import br.com.fiap.seatech.dto.fishing.FishingUpdateDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "tb_pescaria")
public class Fishing {

    @Id
    @GeneratedValue
    @Column(name = "cd_pescaria")
    private Long id;

    @Column(name = "dt_pescaria", nullable = false)
    private LocalDate date;

    @Column(name = "ds_localizacao",length = 300, nullable = false)
    private String localization;

    @Column(name = "ds_condicoes_climaticas", nullable = false)
    private String climateConditions;

    @Column(name = "tp_pesca",length = 50, nullable = false)
    private String fishing;

    @Column(name = "ds_metodo_pesca",length = 100, nullable = false)
    private String fishingMethod;

    @Column(name = "ds_detalhes", length = 300, nullable = false)
    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_usuario", nullable = false)
    private User user;

    @OneToMany(mappedBy = "fishing", cascade = CascadeType.ALL)
    private List<Catch> catchs;

    public Fishing(FishingRegisterDto dto, User user) {
        date = dto.date();
        localization = dto.localization();
        fishing = dto.fishing();
        climateConditions = dto.climateConditions();
        fishingMethod = dto.fishingMethod();
        details = dto.details();
        this.user = user;
    }

    public void update(FishingUpdateDto dto) {
        if(dto.date() != null){
            date = dto.date();
        }
        if(dto.localization() != null){
            localization = dto.localization();
        }
        if(dto.climateConditions() != null){
            climateConditions = dto.climateConditions();
        }
        if(dto.fishing() != null){
            fishing = dto.fishing();
        }
        if(dto.fishingMethod() != null){
            fishingMethod = dto.fishingMethod();
        }
        if(dto.details() != null){
            details = dto.details();
        }
    }
}
