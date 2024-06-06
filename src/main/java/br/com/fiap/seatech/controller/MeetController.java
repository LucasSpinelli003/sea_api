package br.com.fiap.seatech.controller;

import br.com.fiap.seatech.domain.Meet;
import br.com.fiap.seatech.domain.Offer;
import br.com.fiap.seatech.dto.meet.MeetDetailDto;
import br.com.fiap.seatech.dto.meet.MeetListDto;
import br.com.fiap.seatech.dto.meet.MeetRegisterDto;
import br.com.fiap.seatech.dto.meet.MeetUpdateDto;
import br.com.fiap.seatech.dto.offer.OfferDetailDto;
import br.com.fiap.seatech.dto.offer.OfferListDto;
import br.com.fiap.seatech.dto.offer.OfferRegisterDto;
import br.com.fiap.seatech.dto.offer.OfferUpdateDto;
import br.com.fiap.seatech.repository.MeetRepository;
import br.com.fiap.seatech.repository.OfferRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/meets")
public class MeetController {

    @Autowired
    private MeetRepository meetRepository;

    @Autowired
    private OfferRepository offerRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<MeetDetailDto> create(@RequestBody @Valid MeetRegisterDto dto, UriComponentsBuilder uriBuilder){
        var meet = new Meet(dto);
        meetRepository.save(meet);
        var uri = uriBuilder.path("/meets/{id}").buildAndExpand(meet.getId()).toUri();
        return ResponseEntity.created(uri).body(new MeetDetailDto(meet));
    }

    @PostMapping("{meetId}/offers")
    @Transactional
    public ResponseEntity<OfferDetailDto> createOffer(@PathVariable Long meetId , @RequestBody @Valid OfferRegisterDto dto, UriComponentsBuilder uriBuilder){
        var meet = meetRepository.getReferenceById(meetId);
        var offer = new Offer(dto, meet);
        offerRepository.save(offer);
        var uri = uriBuilder.path("/meets/offer/{id}").buildAndExpand(offer.getId()).toUri();
        return ResponseEntity.created(uri).body(new OfferDetailDto(offer));
    }

    @PutMapping("offers/{offerId}")
    @Transactional
    public ResponseEntity<OfferDetailDto> updateOffer(@PathVariable Long offerId , @RequestBody @Valid OfferUpdateDto dto){
        var offer = offerRepository.getReferenceById(offerId);
        offer.update(dto);
        offerRepository.save(offer);
        return ResponseEntity.ok(new OfferDetailDto(offer));
    }

    @PutMapping("{meetId}")
    @Transactional
    public ResponseEntity<MeetDetailDto> update(@PathVariable Long meetId, @RequestBody MeetUpdateDto dto){
        var meet = meetRepository.getReferenceById(meetId);
        meet.update(dto);
        meetRepository.save(meet);
        return ResponseEntity.ok(new MeetDetailDto(meet));
    }

    @GetMapping
    public ResponseEntity<List<MeetListDto>> list(Pageable pageable){
        var lista = meetRepository.findAll(pageable).stream().map(MeetListDto::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("offers")
    public ResponseEntity<List<OfferListDto>> listOffers(Pageable pageable){
        var lista = offerRepository.findAll(pageable).stream().map(OfferListDto::new).toList();
        return ResponseEntity.ok(lista);
    }


}
