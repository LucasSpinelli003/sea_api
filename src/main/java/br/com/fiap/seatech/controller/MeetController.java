package br.com.fiap.seatech.controller;

import br.com.fiap.seatech.domain.Catch;
import br.com.fiap.seatech.domain.Meet;
import br.com.fiap.seatech.dto.catchh.CatchDetailDto;
import br.com.fiap.seatech.dto.catchh.CatchRegisterDto;
import br.com.fiap.seatech.dto.meet.MeetDetailDto;
import br.com.fiap.seatech.dto.meet.MeetRegisterDto;
import br.com.fiap.seatech.repository.MeetRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/meets")
public class MeetController {

    @Autowired
    private MeetRepository meetRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<MeetDetailDto> create(@RequestBody @Valid MeetRegisterDto dto, UriComponentsBuilder uriBuilder){
        var meet = new Meet(dto);
        meetRepository.save(meet);
        var uri = uriBuilder.path("/meets/{id}").buildAndExpand(meet.getId()).toUri();
        return ResponseEntity.created(uri).body(new MeetDetailDto(meet));
    }

}
