package br.com.fiap.seatech.controller;

import br.com.fiap.seatech.domain.Fishing;
import br.com.fiap.seatech.dto.fishing.FishingDetailDto;
import br.com.fiap.seatech.dto.fishing.FishingRegisterDto;
import br.com.fiap.seatech.dto.user.*;
import br.com.fiap.seatech.domain.User;
import br.com.fiap.seatech.repository.FishingRepository;
import br.com.fiap.seatech.repository.MeetRepository;
import br.com.fiap.seatech.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FishingRepository fishingRepository;
    @Autowired
    private MeetRepository meetRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<UserDetailDto> create(@RequestBody @Valid UserRegisterDto dto, UriComponentsBuilder uriBuilder){
        var user = new User(dto);
        userRepository.save(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDetailDto(user));
    }

    @PutMapping("{userId}/meets/{meetId}")
    @Transactional
    public ResponseEntity<UserListDto> addMeet(@PathVariable Long userId, @PathVariable Long meetId ){
        var user = userRepository.getReferenceById(userId);
        var meet = meetRepository.getReferenceById(meetId);
        user.getMeets().add(meet);
        userRepository.save(user);

        return ResponseEntity.ok(new UserListDto(user));

    }


    @PostMapping("{userId}/fishing")
    @Transactional
    public ResponseEntity<FishingDetailDto> createFishing(@PathVariable Long userId, @RequestBody @Valid FishingRegisterDto dto, UriComponentsBuilder uriBuilder){
        var user = userRepository.getReferenceById(userId);
        var fishing = new Fishing(dto, user);
        fishingRepository.save(fishing);
        var uri = uriBuilder.path("/users/fishing/{id}").buildAndExpand(fishing.getId()).toUri();
        return ResponseEntity.created(uri).body(new FishingDetailDto(fishing));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody @Valid UserValidationDto dto){
        var user = userRepository.searchByEmail(dto.email());
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        if(!user.getPassword().equals(dto.password())){
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(new UserAuthenticateDetailDto(user));
    }

    @GetMapping
    public ResponseEntity<List<UserListDto>> listPaginated(Pageable pageable) {
        var list = userRepository.findAll(pageable).stream().map(UserListDto::new).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserListDto> searchById(@PathVariable("id") Long id){
        var user = userRepository.getReferenceById(id);
        return ResponseEntity.ok(new UserListDto(user));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity <UserDetailDto> update(@PathVariable("id") Long id, @RequestBody  @Valid UserUpdateDto dto){
        var user = userRepository.getReferenceById(id);
        user.updateData(dto);
        return ResponseEntity.ok(new UserDetailDto(user));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
