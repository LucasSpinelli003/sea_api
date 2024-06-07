package br.com.fiap.seatech.controller;

import br.com.fiap.seatech.dto.catchh.CatchDetailDto;
import br.com.fiap.seatech.dto.catchh.CatchListDto;
import br.com.fiap.seatech.dto.catchh.CatchUpdateDto;
import br.com.fiap.seatech.dto.fishing.FishingListDto;
import br.com.fiap.seatech.repository.CatchRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/catchs")
public class CatchController {

    @Autowired
    private CatchRepository catchRepository;

    @GetMapping
    public ResponseEntity<List<CatchListDto>> list(Pageable pageable){
        var list = catchRepository.findAll().stream().map(CatchListDto::new).toList();
        return ResponseEntity.ok(list);
    }

    @PutMapping("{catchId}")
    @Transactional
    public ResponseEntity<CatchDetailDto> update(@RequestBody CatchUpdateDto dto, @PathVariable Long catchId){
        var catchItem = catchRepository.getReferenceById(catchId);
        catchItem.update(dto);
        catchRepository.save(catchItem);
        return ResponseEntity.ok(new CatchDetailDto(catchItem));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        catchRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
