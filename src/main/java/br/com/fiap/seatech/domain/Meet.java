package br.com.fiap.seatech.domain;


import br.com.fiap.seatech.dto.catchh.CatchRegisterDto;
import br.com.fiap.seatech.dto.meet.MeetRegisterDto;
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
    private String status;

    @ManyToMany(mappedBy = "meets")
    private List<User> users;

    public Meet(MeetRegisterDto dto) {
        date = dto.date();
        local = dto.local();
        status = dto.status();

    }
}
