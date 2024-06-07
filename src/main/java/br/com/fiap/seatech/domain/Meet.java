package br.com.fiap.seatech.domain;


import br.com.fiap.seatech.dto.catchh.CatchRegisterDto;
import br.com.fiap.seatech.dto.meet.MeetRegisterDto;
import br.com.fiap.seatech.dto.meet.MeetUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name="tb_encontro")
public class Meet {

    @Id
    @GeneratedValue
    @Column(name = "cd_encontro")
    private Long id;

    @Column(name = "dt_encontro", nullable = false)
    private LocalDate date;

    @Column(name = "ds_local", length = 100 ,nullable = false)
    private String local;

    @Column(name = "ds_status", length = 50 ,nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(mappedBy = "meets", cascade = CascadeType.REMOVE)
    private List<User> users;

    @OneToMany(mappedBy = "meet", cascade = CascadeType.ALL)
    private List<Offer> offers;

    public Meet(MeetRegisterDto dto) {
        date = dto.date();
        local = dto.local();
        status = dto.status();
    }

    public void update(MeetUpdateDto dto){
        if(dto.date() != null){
            date = dto.date();
        }
        if(dto.local() != null){
            local = dto.local();
        }
        if(dto.status() != null){
            status = dto.status();
        }
    }
}
