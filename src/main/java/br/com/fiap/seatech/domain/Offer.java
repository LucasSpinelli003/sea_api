package br.com.fiap.seatech.domain;


import br.com.fiap.seatech.dto.offer.OfferRegisterDto;
import br.com.fiap.seatech.dto.offer.OfferUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name="tb_oferta")
public class Offer {

    @Id
    @GeneratedValue
    @Column(name= "cd_oferta")
    private Long id;

    @Column(name = "ds_especie", length = 100, nullable = false)
    private String species;

    @Column(name = "ds_quantidade", nullable = false)
    private Integer amount;

    @Column( name = "vl_oferta", nullable = false)
    private Double price;

    @Column(name = "ds_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_encontro", nullable = false)
    private Meet meet;

    public Offer(OfferRegisterDto dto, Meet meet){
        species = dto.species();
        amount = dto.amount();
        price = dto.price();
        status = dto.status();
        this.meet = meet;
    }
    public void update(OfferUpdateDto dto){
    if(dto.species() != null){
        species = dto.species();
    }
    if(dto.amount() != null){
        amount = dto.amount();
    }
    if(dto.price() != null){
        price = dto.price();
    }
    if(dto.status() !=null){
        status = dto.status();
    }
    }


}

