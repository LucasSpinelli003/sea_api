package br.com.fiap.seatech.controller;

import br.com.fiap.seatech.domain.Catch;
import br.com.fiap.seatech.domain.Fishing;
import br.com.fiap.seatech.dto.catchh.CatchDetailDto;
import br.com.fiap.seatech.dto.catchh.CatchRegisterDto;
import br.com.fiap.seatech.dto.fishing.FishingDetailDto;
import br.com.fiap.seatech.dto.fishing.FishingListDto;
import br.com.fiap.seatech.dto.fishing.FishingRegisterDto;
import br.com.fiap.seatech.dto.fishing.FishingUpdateDto;
import br.com.fiap.seatech.dto.user.*;
import br.com.fiap.seatech.domain.User;
import br.com.fiap.seatech.repository.CatchRepository;
import br.com.fiap.seatech.repository.FishingRepository;
import br.com.fiap.seatech.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping("/fishings")
public class FishingController {
    @Autowired
    private FishingRepository fishingRepository;

    @Autowired
    private CatchRepository catchRepository;

    @PostMapping("{fishingId}/catch")
    @Transactional
    public ResponseEntity<CatchDetailDto> createCatch(@PathVariable Long fishingId, @RequestBody @Valid CatchRegisterDto dto, UriComponentsBuilder uriBuilder){
        var fishing = fishingRepository.getReferenceById(fishingId);
        var catchObject = new Catch(dto, fishing);
        catchRepository.save(catchObject);
        var uri = uriBuilder.path("/fishings/catch/{id}").buildAndExpand(catchObject.getId()).toUri();
        return ResponseEntity.created(uri).body(new CatchDetailDto(catchObject));
    }

    @GetMapping
    public ResponseEntity<List<FishingListDto>> list(Pageable pageable){
        var list = fishingRepository.findAll(pageable).stream().map(FishingListDto::new).toList();
        return ResponseEntity.ok(list);
    }

    @PutMapping("{fishingId}")
    @Transactional
    public ResponseEntity<FishingDetailDto> update(@PathVariable Long fishingId , @RequestBody FishingUpdateDto dto){
        var fishing = fishingRepository.getReferenceById(fishingId);
        fishing.update(dto);
        fishingRepository.save(fishing);
        return ResponseEntity.ok(new FishingDetailDto(fishing));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        fishingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
